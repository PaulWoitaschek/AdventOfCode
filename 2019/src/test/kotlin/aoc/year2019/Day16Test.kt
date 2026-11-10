package aoc.year2019

import aoc.library.solvePart1
import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class Day16Test {

  @Test
  fun onePhase() {
    assertEquals("48226158", Day16.process(input = "12345678", phases = 1))
  }

  @Test
  fun twoPhases() {
    assertEquals("34040438", Day16.process(input = "12345678", phases = 2))
  }

  @Test
  fun part1Test() {
    assertEquals("24176176", Day16.solvePart1("80871224585914546619083218645595"))
  }

  @Test
  fun part1() {
    assertEquals("15841929", Day16.solvePart1())
  }
}
