package aoc.year2025

import aoc.library.solvePart1
import aoc.library.solvePart2
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class Day2Test {

  private val testInput = """
      11-22,95-115,998-1012,1188511880-1188511890,222220-222224,
      1698522-1698528,446443-446449,38593856-38593862,565653-565659,
      824824821-824824827,2121212118-2121212124
  """.trimIndent()

  @Test
  fun `part 1 valid ids test`() {
    listOf(10, 20, 1011, 111).forEach {
      assertTrue(Day2.isValidId1(it.toLong()))
    }
  }

  @Test
  fun `part 1 invalid ids test`() {
    listOf(11, 22, 1010, 1188511885, 222222, 38593859).forEach {
      assertFalse(Day2.isValidId1(it.toLong()))
    }
  }

  @Test
  fun `part 2 invalid ids test`() {
    listOf(824824824).forEach {
      assertFalse(Day2.isValidId2(it.toLong()))
    }
  }

  @Test
  fun part1TestInput() {
    assertEquals(
      1227775554,
      Day2.solvePart1(
        testInput,
      ),
    )
  }

  @Test
  fun part1() {
    assertEquals(28846518423, Day2.solvePart1())
  }

  @Test
  fun part2TestInput() {
    assertEquals(4174379265, Day2.solvePart2(testInput))
  }

  @Test
  fun part2() {
    assertEquals(31578210022, Day2.solvePart2())
  }
}
