package de.woitaschek.aoc.year2022

import de.woitaschek.aoc.aocInput
import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.Scope
import org.openjdk.jmh.annotations.Setup
import org.openjdk.jmh.annotations.State

@State(Scope.Benchmark)
class Day5Benchmark {

  lateinit var input: String

  @Setup
  fun setUp() {
    input = aocInput(2022, 5)
  }

  @Benchmark
  fun part1() {
    Day5.solvePart1(input)
  }

  @Benchmark
  fun part2() {
    Day5.solvePart2(input)
  }
}
