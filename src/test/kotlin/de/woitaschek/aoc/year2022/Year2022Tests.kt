package de.woitaschek.aoc.year2022

import de.woitaschek.aoc.AocTest
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class Year2022Tests : AocTest(2022) {

  @Test
  fun day1() {
    Day1.test(part1 = 65912, part2 = 195625)
  }

  @Test
  @Disabled
  fun solveTestInput() {
    Day1.solvePart1(testInput()) shouldBe 24000L
    Day1.solvePart2(testInput()) shouldBe 45000L
  }
}
