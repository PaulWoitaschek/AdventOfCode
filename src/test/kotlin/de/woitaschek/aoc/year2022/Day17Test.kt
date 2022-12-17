package de.woitaschek.aoc.year2022

import de.woitaschek.aoc.aocInput
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day17Test {

  @Test
  fun part1Test() {
    Day17.solvePart1(">>><<><>><<<>><>>><<<>>><<<><<<>><>><<>>", reportOnRock = 2022)
      .shouldBe(3068L)
  }

  @Test
  fun part1() {
    Day17.solvePart1(aocInput(2022, 17).lines().first(), reportOnRock = 2022)
      .shouldBe(3181L)
  }
}
