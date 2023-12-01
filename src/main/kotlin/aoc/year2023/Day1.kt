package aoc.year2023

import aoc.utils.Puzzle
import aoc.utils.toLineSeparatedStringList

object Day1 : Puzzle<Int, Int>(2023, 1) {

  override fun solvePart1(input: String): Int {
    return input.toLineSeparatedStringList()
      .map {
        val firstDigit = it.first(Char::isDigit)
        val lastDigit = it.reversed().first(Char::isDigit)
        "$firstDigit$lastDigit".toInt()
      }
      .fold(0, Int::plus)
  }

  override fun solvePart2(input: String): Int {
    val numbers = (1..9).associateBy { it.toString() } + (1..9).associateBy { number ->
      when (number) {
        1 -> "one"
        2 -> "two"
        3 -> "three"
        4 -> "four"
        5 -> "five"
        6 -> "six"
        7 -> "seven"
        8 -> "eight"
        9 -> "nine"
        else -> error("Invalid number $number")
      }
    }

    return input.toLineSeparatedStringList()
      .map { line ->
        val min = numbers.getValue(line.findAnyOf(numbers.keys)!!.second)
        val max = numbers.getValue(line.findLastAnyOf(numbers.keys)!!.second)
        "$min$max".toInt()
      }
      .fold(0, Int::plus)
  }
}
