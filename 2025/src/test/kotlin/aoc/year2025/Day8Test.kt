package aoc.year2025

import aoc.library.solvePart1
import aoc.library.solvePart2
import io.kotest.matchers.longs.shouldBeExactly
import org.junit.jupiter.api.Test

class Day8Test {
  private val testInput: String = """
    162,817,812
    57,618,57
    906,360,560
    592,479,940
    352,342,300
    466,668,158
    542,29,236
    431,825,988
    739,650,466
    52,470,668
    216,146,977
    819,987,18
    117,168,530
    805,96,715
    346,949,466
    970,615,88
    941,993,340
    862,61,35
    984,92,344
    425,690,689
  """.trimIndent()

  @Test
  fun part1TestInput() {
    Day8(10).solvePart1(testInput) shouldBeExactly 40
  }

  @Test
  fun part1() {
    Day8(1000).solvePart1() shouldBeExactly 103488
  }

  @Test
  fun part2TestInput() {
    Day8(10).solvePart2(testInput) shouldBeExactly 25272
  }

  @Test
  fun part2() {
    Day8(10).solvePart2() shouldBeExactly 8759985540
  }
}
