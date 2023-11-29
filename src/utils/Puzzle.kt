package utils

abstract class Puzzle<Part1, Part2>(val year: Int, val day: Int) {
  abstract fun solvePart1(input: String): Part1
  abstract fun solvePart2(input: String): Part2
}
