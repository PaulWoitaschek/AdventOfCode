package year2015

import utils.Puzzle
import utils.toLineSeparatedStringList

object Day8 : Puzzle<Int, Int>(2015, 8) {

  override fun solvePart1(input: String): Int = input.toLineSeparatedStringList()
    .sumOf { it.length - memoryCount(it) }

  override fun solvePart2(input: String): Int = input.toLineSeparatedStringList()
    .sumOf { encodedSize(it) - it.length }

  fun memoryCount(string: String): Int {
    return string.replace("""(\\\\|\\"|\\x..)""".toRegex(), "d").length - 2
  }

  fun encodedSize(string: String): Int {
    return string.length + string.count { it == '"' } + string.count { it == '\\' } + 2
  }
}
