package aoc.year2024

import aoc.library.Puzzle
import kotlin.math.abs

object Day1 : Puzzle<Long, Long>(day = 1) {

  override fun solvePart1(input: String): Long {
    val (left, right) = parse(input)
    return left.sorted().zip(right.sorted()) { l, r ->
      abs(l - r)
    }.sum()
  }

  override fun solvePart2(input: String): Long {
    val (left, right) = parse(input)
    val grouping = right.groupingBy { it }.eachCount()
    return left.sumOf { it * grouping.getOrElse(it) { 0 } }
  }

  private fun parse(input: String): Pair<List<Long>, List<Long>> {
    val left = mutableListOf<Long>()
    val right = mutableListOf<Long>()
    val numberRegex = "(\\d+) *(\\d+)".toRegex()
    input.lines().forEach { line ->
      val (leftValue, rightValue) = numberRegex.find(line)!!.destructured.toList().map(String::toLong)
      left += leftValue
      right += rightValue
    }
    return left to right
  }
}
