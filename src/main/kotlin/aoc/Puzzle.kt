package aoc

interface Puzzle {

  val day: Int

  fun solvePart1(input: String): Any

  fun solvePart2(input: String): Any
}
