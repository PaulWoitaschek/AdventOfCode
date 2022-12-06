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

fun Puzzle.input(): String = aocInput(year = year, day = day)

fun Puzzle.testInput(): String = aocTestInput(year = year, day = day)

@Suppress("unused")
fun testInput(): String = input("testinput.txt")

fun aocInput(year: Int, day: Int): String {
  return input("$year/day$day.txt")
}

fun aocTestInput(year: Int, day: Int): String {
  return input("$year/day${day}test.txt")
}


private fun input(fileName: String): String {
  return ClassLoader
    .getSystemResourceAsStream(fileName)!!
    .bufferedReader()
    .readText()
}
