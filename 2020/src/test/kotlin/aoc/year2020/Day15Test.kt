package aoc.year2020

import kotlin.test.assertEquals
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class Day15Test {

  @Test
  fun part1() {
    assertEquals(436, Day15.solvePart1("0,3,6"))
    assertEquals(639, Day15.solvePart1("11,18,0,20,1,7,16"))
  }

  @Test
  @Disabled("Too slow")
  fun part2() {
    assertEquals(266, Day15.solvePart2("11,18,0,20,1,7,16"))
  }
}
