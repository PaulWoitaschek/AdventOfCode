package aoc

interface Puzzle {

  val day: Int

  fun solvePart1(input: String): Long

  fun solvePart2(input: String): Long
}
