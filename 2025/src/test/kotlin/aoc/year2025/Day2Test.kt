package aoc.year2025

import aoc.library.solvePart1
import aoc.library.solvePart2
import io.kotest.assertions.withClue
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.longs.shouldBeExactly
import org.junit.jupiter.api.Test

class Day2Test {

  private val testInput = """
      11-22,95-115,998-1012,1188511880-1188511890,222220-222224,
      1698522-1698528,446443-446449,38593856-38593862,565653-565659,
      824824821-824824827,2121212118-2121212124
  """.trimIndent()

  @Test
  fun `part 1 valid ids test`() {
    listOf(10, 20, 1011, 111).forEach {
      withClue(it) {
        Day2.isValidId(it.toLong()).shouldBeTrue()
      }
    }
  }

  @Test
  fun `part 1 invalid ids test`() {
    listOf(11, 22, 1010, 1188511885, 222222, 38593859).forEach {
      withClue(it) {
        Day2.isValidId(it.toLong()).shouldBeFalse()
      }
    }
  }

  @Test
  fun `part 2 invalid ids test`() {
    listOf(824824824).forEach {
      withClue(it) {
        Day2.isValidId2(it.toLong()).shouldBeFalse()
      }
    }
  }

  @Test
  fun part1TestInput() {
    Day2.solvePart1(
      testInput,
    ) shouldBeExactly 1227775554
  }

  @Test
  fun part1() {
    Day2.solvePart1() shouldBeExactly 28846518423
  }

  @Test
  fun part2TestInput() {
    Day2.solvePart2(testInput) shouldBeExactly 4174379265
  }

  @Test
  fun part2() {
    Day2.solvePart2() shouldBeExactly 31578210022
  }
}
