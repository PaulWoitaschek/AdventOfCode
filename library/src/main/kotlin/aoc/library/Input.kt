package aoc.utils

import java.io.File

fun Puzzle<*, *>.input(): String = aocInput(year = year, day = day)

fun Puzzle<*, *>.testInput(): String = aocTestInput(year = year, day = day)

fun <Part1, Part2> Puzzle<Part1, Part2>.solvePart1(): Part1 = solvePart1(input())

fun <Part1, Part2> Puzzle<Part1, Part2>.solvePart1WithTestInput(): Part1 = solvePart1(testInput())

fun <Part1, Part2> Puzzle<Part1, Part2>.solvePart2(): Part2 = solvePart2(input())

fun <Part1, Part2> Puzzle<Part1, Part2>.solvePart2WithTestInput(): Part2 = solvePart2(testInput())

@Suppress("unused")
fun testInput(): String = input("testinput.txt")

fun aocInput(
  year: Int,
  day: Int,
): String {
  return input("$year/day$day.txt")
}

fun aocTestInput(
  year: Int,
  day: Int,
): String {
  return input("$year/day${day}test.txt")
}

fun input(fileName: String): String = File("../inputs", fileName).readText()
