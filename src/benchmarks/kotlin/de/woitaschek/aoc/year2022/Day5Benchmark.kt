package de.woitaschek.aoc.year2022

import de.woitaschek.aoc.aocInput
import kotlinx.benchmark.Benchmark
import kotlinx.benchmark.Scope
import kotlinx.benchmark.Setup
import kotlinx.benchmark.State

@State(Scope.Benchmark)
class Day5Benchmark {

  lateinit var input: String

  @Setup
  fun setUp() {
    input = aocInput(2022, 5)
  }

  @Benchmark
  fun part1() = Day5.solvePart1(input)

  @Benchmark
  fun part2() = Day5.solvePart2(input)
}
