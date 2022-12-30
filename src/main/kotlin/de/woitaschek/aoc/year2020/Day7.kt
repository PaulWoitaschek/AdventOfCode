package de.woitaschek.aoc.year2020

import de.woitaschek.aoc.utils.Puzzle

object Day7 : Puzzle(2020, 7) {

  private const val shinyGold = "shiny gold"

  override fun solvePart1(input: String): Int {
    val bagRules = parseInput(input)

    fun canContainShinyGoldBag(color: String): Boolean {
      return if (color == shinyGold) true
      else bagRules[color]!!.any {
        canContainShinyGoldBag(it.key)
      }
    }

    return bagRules.keys
      .filter { it != shinyGold }
      .count(::canContainShinyGoldBag)
  }

  override fun solvePart2(input: String): Int {
    val bagRules = parseInput(input)

    fun bagCount(color: String): Int {
      val contents = bagRules.getValue(color)
      return 1 + contents.toList().sumOf { (contentColor, count) ->
        count * bagCount(contentColor)
      }
    }

    return bagCount(shinyGold) - 1
  }

  private fun parseInput(input: String): Map<String, Map<String, Int>> {
    val contentsRegex = "(\\d+) (.*?) bag".toRegex()
    return input.lines().filter(String::isNotBlank)
      .associate { rule ->
        val color = rule.substringBefore(" bags")
        val contents = rule.substringAfter("contain ").split(", ")
          .filter { it != "no other bags." }
          .associate {
            val (count, contentColor) = contentsRegex.find(it)!!.destructured
            contentColor to count.toInt()
          }
        color to contents
      }
  }
}
