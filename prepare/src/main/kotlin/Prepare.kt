import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.terminal
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.options.prompt
import com.github.ajalt.clikt.parameters.types.int
import com.github.ajalt.mordant.terminal.YesNoPrompt
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.INT
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.MemberName
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeSpec
import java.awt.Toolkit
import java.awt.datatransfer.DataFlavor
import java.io.File
import java.time.LocalDate

class Prepare : CliktCommand() {

  private val year: Int by option().int().prompt(default = LocalDate.now().year)
  private val day: Int by option().int().prompt(default = LocalDate.now().dayOfMonth)

  override fun run() {
    generateDayTestSourceFile()
    generateDaySourceFile()
    writeTestInput()
  }

  private fun writeTestInput() {
    val testInputFile = File("$year/src/main/resources/$year/$day-test.txt")
    if (testInputFile.exists()) {
      println("Test input $testInputFile exists already. Don't overwrite")
      return
    }
    if (YesNoPrompt(
        prompt = "Paste test input from clipboard?",
        terminal = terminal,
        default = false,
      ).ask() != true
    ) {
      return
    }
    val pasted = Toolkit.getDefaultToolkit().systemClipboard.getData(DataFlavor.stringFlavor)
    testInputFile.parentFile.mkdirs()
    if (pasted is String && pasted.isNotBlank()) {
      testInputFile.writeText(pasted.trim())
    } else {
      testInputFile.createNewFile()
    }
  }

  private fun generateDaySourceFile() {
    val sourceFileContent = FileSpec.builder("aoc.year$year", "Day$day")
      .addType(
        TypeSpec.objectBuilder("Day$day")
          .superclass(ClassName("aoc.library", "Puzzle").parameterizedBy(INT, INT))
          .addSuperclassConstructorParameter("year = $year, day = $day")
          .addFunction(createSolveFunction("Part1"))
          .addFunction(createSolveFunction("Part2"))
          .build(),
      )
      .build()

    sourceFileContent.writeTo(File("$year/src/main/kotlin"))
  }

  private fun createSolveFunction(part: String): FunSpec {
    return FunSpec.builder("solve$part")
      .addParameter("input", String::class)
      .addModifiers(KModifier.OVERRIDE)
      .returns(Int::class)
      .addStatement("TODO()")
      .build()
  }

  private fun createTestFunction(
    name: String,
    solveName: String,
  ): FunSpec {
    return FunSpec.builder(name)
      .addAnnotation(ClassName("org.junit.jupiter.api", "Test"))
      .addStatement(
        "Day%L.%M() %M 42",
        day,
        MemberName("aoc.library", solveName),
        MemberName("io.kotest.matchers.ints", "shouldBeExactly"),
      )
      .build()
  }

  private fun generateDayTestSourceFile() {
    val testFileContent = FileSpec.builder("aoc.year$year", "Day${day}Test")
      .addType(
        TypeSpec.classBuilder("Day${day}Test")
          .addProperty(
            PropertySpec.builder("testInput", String::class)
              .initializer("%S", "")
              .build(),
          )
          .addFunction(createTestFunction(name = "part1", "solvePart1"))
          .addFunction(createTestFunction(name = "part1TestInput", "solvePart1WithTestInput"))
          .addFunction(createTestFunction(name = "part2", "solvePart2"))
          .addFunction(createTestFunction(name = "part2TestInput", "solvePart2WithTestInput"))
          .build(),
      )
      .build()

    testFileContent.writeTo(File("$year/src/test/kotlin"))
  }
}

fun main(args: Array<String>) {
  Prepare().main(args)
}
