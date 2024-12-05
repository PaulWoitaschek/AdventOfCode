package aoc.year2024

import aoc.library.Puzzle

object Day5 : Puzzle<Long, Long>(day = 5) {

  override fun solvePart1(input: String): Long {
    //  println(input)

    val (orderingRulesValue, pagesValue) = input.split("\n\n")

    val orderingRules = orderingRulesValue.lines().map {
      val (l, r) = it.split("|")
      l.toLong() to r.toLong()
    }

    val pages = pagesValue.lines()
      .map {
        it.split(",").map { it.toLong() }
      }

    val comparator = Comparator<Long> { o1, o2 ->
      val rule = orderingRules.first { (it.first == o1 && it.second == o2) || (it.first == o2 && it.second == o1) }
      if (o1 == rule.first) -1 else 1
    }

    return pages
      .filter {
        it.sortedWith(comparator) == it
      }
      .sumOf { it[it.count() / 2] }
  }

  override fun solvePart2(input: String): Long {
    val (orderingRulesValue, pagesValue) = input.split("\n\n")

    val orderingRules = orderingRulesValue.lines().map {
      val (l, r) = it.split("|")
      l.toLong() to r.toLong()
    }

    val pages = pagesValue.lines()
      .map {
        it.split(",").map { it.toLong() }
      }

    val comparator = Comparator<Long> { o1, o2 ->
      val rule = orderingRules.first { (it.first == o1 && it.second == o2) || (it.first == o2 && it.second == o1) }
      if (o1 == rule.first) -1 else 1
    }

    return pages
      .filter {
        it.sortedWith(comparator) != it
      }
      .map { it.sortedWith(comparator) }
      .sumOf { it[it.count() / 2] }
  }
}
