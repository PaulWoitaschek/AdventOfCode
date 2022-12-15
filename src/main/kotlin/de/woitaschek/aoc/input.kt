package de.woitaschek.aoc

import de.woitaschek.aoc.utils.Puzzle

fun Puzzle.input(): String = aocInput(year = year, day = day)

fun Puzzle.testInput(): String = aocTestInput(year = year, day = day)

@Suppress("unused")
fun testInput(): String = input("testinput.txt")

fun aocInput(year: Int, day: Int): String {
  return input("$year/day$day.txt")
}

fun aocTestInput(year: Int, day: Int): String {
  return input("$year/day${day}test.txt")
}


private fun input(fileName: String): String {
  return ClassLoader
    .getSystemResourceAsStream(fileName)!!
    .bufferedReader()
    .readText()
}