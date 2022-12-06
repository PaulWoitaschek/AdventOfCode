package de.woitaschek.aoc.year2022

import de.woitaschek.aoc.aocInput
import kotlinx.benchmark.*

@State(Scope.Benchmark)
class Day1Benchmark {

  lateinit var input: String

  @Setup
  fun setUp() {
    input = aocInput(2022, 1)
  }

  @Benchmark
  fun part1() = Day1.solvePart1(input)

  @Benchmark
  fun part2() = Day1.solvePart2(input)
}
