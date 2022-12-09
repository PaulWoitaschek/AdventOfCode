package de.woitaschek.aoc.utils

abstract class Puzzle(val year: Int, val day: Int) {
  abstract fun solvePart1(input: String): Any
  abstract fun solvePart2(input: String): Any
}