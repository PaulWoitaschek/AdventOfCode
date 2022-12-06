package de.woitaschek.aoc

import de.woitaschek.aoc.utils.Puzzle
import io.kotest.matchers.shouldBe

fun Puzzle.test(part1: Any?, part2: Any?) {
  val input = input()
  if (part1 != null) {
    solvePart1(input) shouldBe part1
  }
  if (part2 != null) {
    solvePart2(input) shouldBe part2
  }
}

fun Puzzle.input(): String = aocInput(year = year, day = day)

@Suppress("unused")
fun testInput(): String = input("testinput.txt")

fun aocInput(year: Int, day: Int): String {
  return input("$year/day$day.txt")
}

private fun input(fileName: String): String {
  return ClassLoader
    .getSystemResourceAsStream(fileName)!!
    .bufferedReader()
    .readText()
}
