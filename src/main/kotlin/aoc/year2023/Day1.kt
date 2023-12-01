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
    val numberNames = (1..9).associateWith { number ->
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
        else -> error("Invalid number")
      }
    }.mapValues { listOf(it.value, it.key.toString()) }

    fun findNumbers(string: String): Map<Int, Int> {
      val foundNumbers = mutableMapOf<Int, Int>()
      numberNames.forEach { (number, numberValues) ->
        numberValues.forEach { numberValue ->
          val index = string.indexOf(numberValue)
          if (index != -1) foundNumbers[index] = number
          val lastIndex = string.lastIndexOf(numberValue)
          if (lastIndex != -1) foundNumbers[lastIndex] = number
        }
      }
      return foundNumbers
    }

    return input.toLineSeparatedStringList()
      .map { line ->
        val foundNumbers = findNumbers(line)
        val firstDigit = foundNumbers.minBy { it.key }.value
        val lastDigit = foundNumbers.maxBy { it.key }.value
        "$firstDigit$lastDigit".toInt()
      }
      .fold(0, Int::plus)
  }
}
