package aoc.year2023

import aoc.library.solvePart1
import aoc.library.solvePart2
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day12Test {

  private val testInput = """
      ???.### 1,1,3
      .??..??...?##. 1,1,3
      ?#?#?#?#?#?#?#? 1,3,1,6
      ????.#...#... 4,1,1
      ????.######..#####. 1,6,5
      ?###???????? 3,2,1
  """.trimIndent()

  @Test
  fun part1() {
    assertEquals(6949, Day12.solvePart1())
  }

  @Test
  fun part1TestInput() {
    assertEquals(21, Day12.solvePart1(testInput))
  }

  @Test
  fun part2() {
    assertEquals(51456609952403, Day12.solvePart2())
  }

  @Test
  fun part2TestInput() {
    assertEquals(525152, Day12.solvePart2(testInput))
  }
}
