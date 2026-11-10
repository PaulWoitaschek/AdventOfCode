package aoc.year2023

import aoc.library.solvePart1
import aoc.library.solvePart2
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day15Test {

  private val testInput = "rn=1,cm-,qp=3,cm=2,qp-,pc=4,ot=9,ab=5,pc-,pc=6,ot=7"

  @Test
  fun part1TestInput() {
    assertEquals(1320, Day15.solvePart1(testInput))
  }

  @Test
  fun hash() {
    assertEquals(52, Day15.hash("HASH"))
  }

  @Test
  fun part1() {
    assertEquals(515974, Day15.solvePart1())
  }

  @Test
  fun part2TestInput() {
    assertEquals(145, Day15.solvePart2(testInput))
  }

  @Test
  fun part2() {
    assertEquals(265894, Day15.solvePart2())
  }
}
