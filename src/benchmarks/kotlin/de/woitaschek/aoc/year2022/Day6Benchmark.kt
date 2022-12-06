package de.woitaschek.aoc.year2022

import de.woitaschek.aoc.aocInput
import kotlinx.benchmark.*

@State(Scope.Benchmark)
class Day6Benchmark {

  lateinit var input: String

  @Setup
  fun setUp() {
    input = aocInput(2022, 6)
  }

  @Benchmark
  fun part1() = Day6.solvePart1(input)

  @Benchmark
  fun part2() = Day6.solvePart2(input)
}
