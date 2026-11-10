package aoc.year2017

import aoc.library.solvePart1
import aoc.library.solvePart2
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day9Test {

  @Test
  fun score() {
    assertEquals(9, Day9.score("{{<!!>},{<!!>},{<!!>},{<!!>}}"))
    assertEquals(3, Day9.score("{{<a!>},{<a!>},{<a!>},{<ab>}}"))
  }

  @Test
  fun garbageCount() {
    assertEquals(0, Day9.garbageCount("<>"))
    assertEquals(17, Day9.garbageCount("<random characters>"))
    assertEquals(3, Day9.garbageCount("<<<<>"))
  }

  @Test
  fun part1() {
    assertEquals(21037, Day9.solvePart1())
  }

  @Test
  fun part2() {
    assertEquals(9495, Day9.solvePart2())
  }
}
