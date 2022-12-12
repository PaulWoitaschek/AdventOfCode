package de.woitaschek.aoc.year2022

import de.woitaschek.aoc.aocInput
import kotlinx.benchmark.*

@State(Scope.Benchmark)
class Day12Benchmark {

  lateinit var input: String

  @Setup
  fun setUp() {
    input = aocInput(2022, 12)
  }

  @Benchmark
  fun part2() = Day12.solvePart2(input)
}
