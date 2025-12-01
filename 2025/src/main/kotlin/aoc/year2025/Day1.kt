package aoc.year2025

import aoc.library.Puzzle
import kotlin.Long
import kotlin.String
import kotlin.math.absoluteValue
import kotlin.math.sign

object Day1 : Puzzle<Int, Int>(day = 1) {

  override fun solvePart1(input: String): Int {
    var position = 50
    var password = 0
    input.lines()
      .forEach {
        val right = it.first() == 'R'
        val turn = it.drop(1).toInt()
        if (right) position += turn else position -= turn
        position %= 100
        if (position == 0) password++
      }
    return password
  }

  override fun solvePart2(input: String): Int {
    var position = 50
    var password = 0
    input.lines()
      .forEach {
        val right = it.first() == 'R'
        val turn = it.drop(1).toInt()
        val change = if (right) 1 else -1
        repeat(turn) {
          position += change
          if (position == 100) position = 0
          if (position == -1) position = 99
          if (position == 0) {
            password++
          }
        }
      }
    return password
  }
}
