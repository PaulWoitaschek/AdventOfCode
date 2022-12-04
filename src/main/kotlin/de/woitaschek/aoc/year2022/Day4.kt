package de.woitaschek.aoc.year2022

import de.woitaschek.aoc.Puzzle

object Day4 : Puzzle {

  override val day = 4

  override fun solvePart1(input: String) = input.rangeMatches {
    (x1 >= y1 && x2 <= y2) || (y1 >= x1 && y2 <= x2)
  }

  override fun solvePart2(input: String) = input.rangeMatches {
    x2 >= y1 && x1 <= y2
  }
}

private data class Ranges(val x1: Int, val x2: Int, val y1: Int, val y2: Int)

private inline fun String.rangeMatches(
  match: Ranges.() -> Boolean,
): Int = lines().filter(String::isNotEmpty).count { line ->
  val (x1, x2, y1, y2) = "(\\d+)-(\\d+),(\\d+)-(\\d+)".toRegex().find(line)!!
    .destructured.toList().map(String::toInt)
  match(Ranges(x1, x2, y1, y2))
}
