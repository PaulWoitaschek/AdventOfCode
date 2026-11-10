package aoc.year2021

import aoc.library.solvePart1
import aoc.library.solvePart2
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day10Test {

  private val testInput = """
    [({(<(())[]>[[{[]{<()<>>
    [(()[<>])]({[<{<<[]>>(
    {([(<{}[<>[]}>{[]{[(<()>
    (((({<>}<{<{<>}{[]{[]{}
    [[<[([]))<([[{}[[()]]]
    [{[{({}]{}}([{[{{{}}([]
    {<[[]]>}<{[{[{[]{()[[[]
    [<(<(<(<{}))><([]([]()
    <{([([[(<>()){}]>(<<{{
    <{([{{}}[<[[[<>{}]]]>[]]
  """.trimIndent()

  @Test
  fun part1() {
    assertEquals(364389, Day10.solvePart1())
  }

  @Test
  fun part2() {
    assertEquals(2870201088, Day10.solvePart2())
  }

  @Test
  fun part1TestInput() {
    assertEquals(26397, Day10.solvePart1(testInput))
  }

  @Test
  fun part2TestInput() {
    assertEquals(288957, Day10.solvePart2(testInput))
  }
}
