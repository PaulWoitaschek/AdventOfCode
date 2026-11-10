package aoc.year2019

import aoc.library.solvePart1
import aoc.library.solvePart2
import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class Day11Test {

  @Test
  fun part1() {
    assertEquals(2211, Day11.solvePart1())
  }

  @Test
  fun part2() {
    assertEquals(
      """
      ╔═══════════════════════════════════════╗
      ║████ ████  ██  █  █ █  █ ████  ██   ██ ║
      ║█    █    █  █ █ █  █  █ █    █  █ █  █║
      ║███  ███  █    ██   █  █ ███  █    █   ║
      ║█    █    █    █ █  █  █ █    █ ██ █   ║
      ║█    █    █  █ █ █  █  █ █    █  █ █  █║
      ║████ █     ██  █  █  ██  ████  ███  ██ ║
      ╚═══════════════════════════════════════╝
      """
        .trimIndent(),
      Day11.solvePart2(),
    )
  }
}
