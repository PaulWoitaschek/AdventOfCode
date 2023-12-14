package aoc.library

import java.io.File

fun <Part1, Part2> Puzzle<Part1, Part2>.solvePart1(): Part1 = solvePart1(input())

fun <Part1, Part2> Puzzle<Part1, Part2>.solvePart1WithTestInput(): Part1 = solvePart1(testInput())

fun <Part1, Part2> Puzzle<Part1, Part2>.solvePart2(): Part2 = solvePart2(input())

fun <Part1, Part2> Puzzle<Part1, Part2>.solvePart2WithTestInput(): Part2 = solvePart2(testInput())

fun Puzzle<*, *>.input(): String = aocInput(day = day)

private fun aocInput(day: Int): String {
  val file = File("src/main/resources/$day.txt").apply {
    parentFile.mkdirs()
  }
  return file.readText().removeSuffix("\n")
}

private fun Puzzle<*, *>.testInput(): String = aocTestInput(day = day)

private fun aocTestInput(day: Int): String {
  val file = File("src/main/resources/$day-test.txt")
  return file.readText().removeSuffix("\n")
}
