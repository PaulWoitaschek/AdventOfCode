package de.woitaschek.aoc.year2022

import de.woitaschek.aoc.aocInput
import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.Scope
import org.openjdk.jmh.annotations.Setup
import org.openjdk.jmh.annotations.State


@State(Scope.Benchmark)
class Day1Benchmark {

  lateinit var input: String

  @Setup
  fun setUp() {
    input = aocInput(2022, 1)
  }

  @Benchmark
  fun part1() {
    Day1.solvePart1(input)
  }

  @Benchmark
  fun part2() {
    Day1.solvePart2(input)
  }
}
