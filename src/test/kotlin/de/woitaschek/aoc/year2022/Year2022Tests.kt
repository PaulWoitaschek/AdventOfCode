package de.woitaschek.aoc.year2022

import de.woitaschek.aoc.Puzzle
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Year2022Tests {
  @Test
  fun day1() {
    Day1.test(part1 = 65912, part2 = 195625)
  }
}

private fun Puzzle.test(part1: Any?, part2: Any?) {
  val input = input(day)
  if (part1 != null) {
    solvePart1(input) shouldBe part1
  }
  if (part2 != null) {
    solvePart2(input) shouldBe part2
  }
}


private fun input(day: Int): String = input("2022/day$day.txt")

@Suppress("unused")
fun currentTaskInput(): String = input("2022/task.txt")

fun input(fileName: String): String {
  return ClassLoader
    .getSystemResourceAsStream(fileName)!!
    .bufferedReader()
    .readText()
}
