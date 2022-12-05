package de.woitaschek.aoc.year2022

import de.woitaschek.aoc.test
import de.woitaschek.aoc.testInput
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class Year2022Tests {

  @Test
  fun day1() {
    Day1.test(part1 = 65912, part2 = 195625)
  }

  @Test
  fun day2() {
    Day2.test(part1 = 12535, part2 = 15457)
  }

  @Test
  fun day3() {
    Day3.test(part1 = 8039, part2 = 2510)
  }

  @Test
  fun day4() {
    Day4.test(part1 = 657, part2 = 938)
  }

  @Test
  fun day5() {
    Day5.test(part1 = "SPFMVDTZT", part2 = "ZFSJBPRFP")
  }

  @Test
  @Disabled
  fun solveTestInput() {
    Day5.solvePart2(testInput()) shouldBe "MCD"
  }
}
