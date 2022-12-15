package de.woitaschek.aoc

import de.woitaschek.aoc.utils.Puzzle
import io.kotest.matchers.shouldBe

fun Puzzle.test(
  part1: Any? = null,
  part2: Any? = null,
  part1Test: Any? = null,
  part2Test: Any? = null,
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
