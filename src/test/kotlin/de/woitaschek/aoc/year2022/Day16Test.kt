package de.woitaschek.aoc.year2022

import de.woitaschek.aoc.aocInput
import de.woitaschek.aoc.aocTestInput
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day16Test {

  @Test
  fun part1() {
    Day16.solvePart1(aocInput(2022, 16)) shouldBe 1617
  }

  @Test
  fun part1Test() {
    Day16.solvePart1(aocTestInput(2022, 16)) shouldBe 1651
  }
}
