package aoc.year2017

import aoc.library.solvePart1
import aoc.library.solvePart2
import aoc.year2017.Day16.solve
import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class Day16Test {

  @Test
  fun part1TestInput() {
    assertEquals("eabcd", solve("s1", programCount = 5, danceRounds = 1))
    assertEquals("eabdc", solve("s1,x3/4", programCount = 5, danceRounds = 1))
    assertEquals("eabdc", solve("s1,x4/3", programCount = 5, danceRounds = 1))
    assertEquals("baedc", solve("s1,x3/4,pe/b", programCount = 5, danceRounds = 1))
    assertEquals("baedc", solve("s1,x3/4,pb/e", programCount = 5, danceRounds = 1))
  }

  @Test
  fun part1() {
    assertEquals("pkgnhomelfdibjac", Day16.solvePart1())
  }

  @Test
  fun part2() {
    assertEquals("pogbjfihclkemadn", Day16.solvePart2())
  }
}
