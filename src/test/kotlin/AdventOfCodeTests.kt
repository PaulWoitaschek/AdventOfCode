import aoc.Puzzle
import aoc.day01.Day1
import aoc.day02.Day2
import aoc.day03.Day3
import aoc.day04.Day4
import aoc.day05.Day5
import aoc.day06.Day6
import aoc.day07.Day7
import aoc.day08.Day8
import aoc.day08.Display
import aoc.day09.Day9
import aoc.day10.Day10
import aoc.day11.Day11
import aoc.day12.Day12
import aoc.day13.Day13
import io.kotest.assertions.assertSoftly
import io.kotest.assertions.withClue
import io.kotest.matchers.shouldBe
import org.junit.Test

class AdventOfCodeTests {


  @Test
  fun day1() {
    Day1.test(part1 = 7, part2 = 5)
  }

  @Test
  fun day2() {
    Day2.test(part1 = 150, part2 = 900)
  }

  @Test
  fun day3() {
    Day3.test(part1 = 198, part2 = 230)
  }

  @Test
  fun day4() {
    Day4.test(part1 = 4512, part2 = 1924)
  }

  @Test
  fun day5() {
    Day5.test(part1 = 5, part2 = 12)
  }

  @Test
  fun day6() {
    Day6.test(part1 = 5934, part2 = 26984457539)
  }

  @Test
  fun day7() {
    Day7.test(part1 = 37, part2 = 168)
  }

  @Test
  fun day8() {
    Day8.test(part1 = 26, part2 = 61229)
  }

  @Test
  fun day8Display() {
    val expected = listOf(
      8394,
      9781,
      1197,
      9361,
      4873,
      8418,
      4548,
      1625,
      8717,
      4315,
    )
    assertSoftly {
      input(8).lines()
        .forEachIndexed { index, line ->
          withClue(line) {
            val outputValue = Display.parse(line).outputValue()
            outputValue shouldBe expected[index]
          }
        }
    }
  }

  @Test
  fun day9() {
    Day9.test(part1 = 15, part2 = 1134)
  }

  @Test
  fun day10() {
    Day10.test(part1 = 26397, part2 = 288957)
  }

  @Test
  fun day11() {
    Day11.test(part1 = 1656, part2 = 195)
  }

  @Test
  fun day12() {
    Day12.test(part1 = 10, part2 = 36)
  }

  @Test
  fun day13() {
    Day13.test(
      part1 = 17,
      part2 = """
        █████
        █   █
        █   █
        █   █
        █████
        
        """.trimIndent()
    )
  }

  private fun Puzzle.test(part1: Any?, part2: Any?) {
    val input = input(day)
    if (part1 != null) {
      solvePart1(input) shouldBe part1
    }
    if (part2 != null) {
      solvePart2(input) shouldBe part2
    }
  }
}

private fun input(day: Int): String = input("day$day.txt")

@Suppress("unused")
fun currentTaskInput(): String = input("task.txt")

fun input(fileName: String): String {
  return ClassLoader
    .getSystemResourceAsStream(fileName)!!
    .bufferedReader()
    .readText()
}