package aoc.year2024

import aoc.library.solvePart1
import aoc.library.solvePart2
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.ints.shouldBeExactly
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class Day17Test {

  @Test
  fun part1TestInput() {
    Day17.solvePart1(
      """
      Register A: 729
      Register B: 0
      Register C: 0

      Program: 0,1,5,4,3,0
      """.trimIndent(),
    ) shouldContainExactly listOf(4, 6, 3, 5, 6, 3, 5, 2, 1, 0)
  }

  @Test
  fun tc1() {
    Day17.Computer(a = 0, b = 0, c = 9, program = listOf(2, 6))
      .apply {
        run()
        b shouldBeExactly 1
      }
  }

  @Test
  fun tc2() {
    Day17.Computer(a = 10, b = 0, c = 0, program = listOf(5, 0, 5, 1, 5, 4))
      .run() shouldContainExactly listOf(0, 1, 2)
  }

  @Test
  fun tc3() {
    Day17.Computer(a = 2024, b = 0, c = 0, program = listOf(0, 1, 5, 4, 3, 0))
      .apply {
        run() shouldContainExactly listOf(4, 2, 5, 6, 7, 7, 7, 7, 3, 1, 0)
        a shouldBeExactly 0
      }
  }

  @Test
  fun tc4() {
    Day17.Computer(a = 0, b = 29, c = 0, program = listOf(1, 7))
      .apply {
        run()
        b shouldBeExactly 26
      }
  }

  @Test
  fun tc5() {
    Day17.Computer(a = 0, b = 2024, c = 43690, program = listOf(4, 0))
      .apply {
        run()
        b shouldBeExactly 44354
      }
  }

  @Test
  fun part1() {
    Day17.solvePart1()
      .also { println(it.joinToString(",")) }
      .shouldBe(listOf(3, 5, 0, 1, 5, 1, 5, 1, 0))
  }

  @Test
  @Disabled
  fun part2TestInput() {
    Day17.solvePart2(
      """
      Register A: 2024
      Register B: 0
      Register C: 0

      Program: 0,3,5,4,3,0
      """.trimIndent(),
    ) shouldBeExactly 117440
  }

  @Test
  @Disabled
  fun part2() {
    Day17.solvePart2() shouldBeExactly 42
  }
}
