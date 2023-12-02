package aoc.year2023

import aoc.utils.Puzzle
import aoc.utils.toLineSeparatedStringList

object Day2 : Puzzle<Int, Int>(2023, 2) {

  override fun solvePart1(input: String): Int {
    val bagContents = mapOf(
      "red" to 12,
      "green" to 13,
      "blue" to 14,
    )
    return parse(input)
      .filter { game ->
        game.shownCubes.all { round ->
          round.all { (shownColor, shownAmount) ->
            shownAmount <= bagContents.getValue(shownColor)
          }
        }
      }
      .sumOf { it.id }
  }

  override fun solvePart2(input: String): Int = parse(input).sumOf { game ->
    buildMap {
      game.shownCubes.forEach { sets ->
        sets.forEach { (color, amount) ->
          put(color, maxOf(getOrDefault(color, amount), amount))
        }
      }
    }.values.reduce(Int::times)
  }

  private fun parse(input: String): List<Game> = input.toLineSeparatedStringList()
    .map { line ->
      val (gameIdValue, gameValue) = line.split(": ")
      Game(
        id = gameIdValue.removePrefix("Game ").toInt(),
        shownCubes = gameValue.split("; ").map { set ->
          set.split(", ")
            .associate { amountWithColor ->
              val (amount, color) = amountWithColor.split(" ")
              color to amount.toInt()
            }
        },
      )
    }

  private data class Game(
    val id: Int,
    val shownCubes: List<Map<String, Int>>,
  )
}
