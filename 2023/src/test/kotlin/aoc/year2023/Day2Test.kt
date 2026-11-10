package aoc.year2023

import aoc.library.solvePart1
import aoc.library.solvePart2
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day2Test {

  private val testInput = """
      Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
      Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
      Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
      Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
      Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green
  """.trimIndent()

  @Test
  fun part1TestInput() {
    assertEquals(8, Day2.solvePart1(testInput))
  }

  @Test
  fun part1() {
    assertEquals(2283, Day2.solvePart1())
  }

  @Test
  fun part2TestInput() {
    assertEquals(2286, Day2.solvePart2(testInput))
  }

  @Test
  fun part2() {
    assertEquals(78669, Day2.solvePart2())
  }
}
