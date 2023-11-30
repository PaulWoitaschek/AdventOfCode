package aoc.utils

import io.kotest.matchers.shouldBe

fun <Part1, Part2> Puzzle<Part1, Part2>.test(
  part1: Part1? = null,
  part2: Part2? = null,
  part1Test: Part1? = null,
  part2Test: Part2? = null,
) {
  if (part1 != null) {
    solvePart1(input()) shouldBe part1
  }
  if (part2 != null) {
    solvePart2(input()) shouldBe part2
  }
  if (part1Test != null) {
    solvePart1(testInput()) shouldBe part1Test
  }
  if (part2Test != null) {
    solvePart2(testInput()) shouldBe part2Test
  }
}
