package de.woitaschek.aoc.year2022

import de.woitaschek.aoc.test
import io.kotest.matchers.collections.shouldBeSorted
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day13Test {

  @Test
  fun simpleListParse() {
    Day13.Package.parse("[1,2]") shouldBe Day13.Package(
      Day13.Package.Element.Multiple(
        listOf(
          Day13.Package.Element.Value(1),
          Day13.Package.Element.Value(2),
        ),
      ),
    )
  }

  @Test
  fun sorting() {
    """
    []
    [[]]
    [[[]]]
    [1,1,3,1,1]
    [1,1,5,1,1]
    [[1],[2,3,4]]
    [1,[2,[3,[4,[5,6,0]]]],8,9]
    [1,[2,[3,[4,[5,6,7]]]],8,9]
    [[1],4]
    [[2]]
    [3]
    [[4,4],4,4]
    [[4,4],4,4,4]
    [[6]]
    [7,7,7]
    [7,7,7,7]
    [[8,7,6]]
    [9]""".trimIndent().lines().map { Day13.Package.parse(it) }
      .shouldBeSorted()
  }

  @Test
  fun part1TestInput() {
    Day13.test(part1Test = 13)
  }

  @Test
  fun part1() {
    Day13.test(part1 = 6568)
  }

  @Test
  fun part2Test() {
    Day13.test(part2Test = 140)
  }

  @Test
  fun part2() {
    Day13.test(part2 = 19493)
  }
}
