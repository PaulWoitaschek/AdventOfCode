import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.options.prompt
import com.github.ajalt.clikt.parameters.types.int
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.INT
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.MemberName
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.TypeSpec
import java.io.File
import java.time.LocalDate

class Prepare : CliktCommand() {

  private val year: Int by option().int().prompt(default = LocalDate.now().year)
  private val day: Int by option().int().prompt(default = LocalDate.now().dayOfMonth)

  override fun run() {
    generateDayTestSourceFile()
    generateDaySourceFile()
  }

  private fun generateDaySourceFile() {
    val sourceFileContent = FileSpec.builder("aoc.year$year", "Day$day")
      .addType(
        TypeSpec.objectBuilder("Day$day")
          .superclass(ClassName("aoc.library", "Puzzle").parameterizedBy(INT, INT))
          .addSuperclassConstructorParameter("day = $day")
          .addFunction(createSolveFunction("Part1"))
          .addFunction(createSolveFunction("Part2"))
          .build(),
      )
      .build()

    sourceFileContent.writeTo(File("$year/src/main/kotlin"))
  }

  private fun createSolveFunction(part: String): FunSpec = FunSpec.builder("solve$part")
    .addParameter("input", String::class)
    .addModifiers(KModifier.OVERRIDE)
    .returns(Int::class)
    .addStatement("TODO()")
    .build()

  private fun createTestFunction(
    name: String,
    solveName: String,
    disabled: Boolean,
  ): FunSpec = FunSpec.builder(name)
    .addAnnotation(ClassName("org.junit.jupiter.api", "Test"))
    .apply {
      if (disabled) {
        addAnnotation(ClassName("org.junit.jupiter.api", "Disabled"))
      }
    }
    .addStatement(
      "Day%L.%M() %M 42",
      day,
      MemberName("aoc.library", solveName),
      MemberName("io.kotest.matchers.ints", "shouldBeExactly"),
    )
    .build()

  private fun generateDayTestSourceFile() {
    val testFileContent = FileSpec.builder("aoc.year$year", "Day${day}Test")
      .addType(
        TypeSpec.classBuilder("Day${day}Test")
          .addFunction(createTestFunction(name = "part1TestInput", solveName = "solvePart1", disabled = false))
          .addFunction(createTestFunction(name = "part1", solveName = "solvePart1", disabled = true))
          .addFunction(createTestFunction(name = "part2TestInput", solveName = "solvePart2", disabled = true))
          .addFunction(createTestFunction(name = "part2", solveName = "solvePart2", disabled = true))
          .build(),
      )
      .build()

    testFileContent.writeTo(File("$year/src/test/kotlin"))
  }
}

fun main(args: Array<String>) {
  Prepare().main(args)
}
