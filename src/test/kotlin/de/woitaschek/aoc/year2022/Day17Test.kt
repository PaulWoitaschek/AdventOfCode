package de.woitaschek.aoc.year2022

import de.woitaschek.aoc.aocInput
import org.junit.jupiter.api.Test

class Day17Test {

  @Test
  fun part1Test() {
    check(Day17.solvePart1(">>><<><>><<<>><>>><<<>>><<<><<<>><>><<>>", reportOnRock = 2022) == 3068L)
  }

  @Test
  fun part1() {
    check(Day17.solvePart1(aocInput(2022, 17).lines().first(), reportOnRock = 2022) == 3181L)
  }
}
