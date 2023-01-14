package de.woitaschek.aoc.year2020

import de.woitaschek.aoc.utils.Puzzle

object Day6 : Puzzle(2020, 6) {

  override fun solvePart1(input: String): Int = input.split("\n\n")
    .filter(String::isNotBlank).sumOf {
      it.replace("\n", "").toSet().count()
    }

  override fun solvePart2(input: String): Int = input.split("\n\n")
    .filter(String::isNotBlank).sumOf {
      val groups = it.lines().filter(String::isNotBlank)
      groups.first().toSet().count { answer ->
        groups.drop(1).all { groupAnswer ->
          answer in groupAnswer
        }
      }
    }
}