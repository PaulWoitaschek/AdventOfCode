package aoc.year2022

import aoc.library.solvePart1
import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class Day17Test {

  @Test
  fun part1Test() {
    assertEquals(3068L, Day17.solvePart1(">>><<><>><<<>><>>><<<>>><<<><<<>><>><<>>"))
  }

  @Test
  fun part1() {
    assertEquals(3181L, Day17.solvePart1())
  }

  @Test
  fun caveRocks() {
    val cave = Day17.Cave()
    assertEquals(false, cave.hasRock(0, 0))
    cave.putRock(0, 0)
    assertEquals(true, cave.hasRock(0, 0))
    cave.putRock(1, 1)
    assertEquals(true, cave.hasRock(0, 0))
    assertEquals(true, cave.hasRock(1, 1))

    cave.putRock(4, 2)
    assertEquals(true, cave.hasRock(4, 2))
    assertEquals(true, cave.hasRock(1, 1))
    assertEquals(false, cave.hasRock(1, 4))
  }

  @Test
  fun caveTop() {
    val cave = Day17.Cave()

    cave.putRock(0, 0)
    assertEquals(0, cave.top())

    cave.putRock(6, 0)
    assertEquals(0, cave.top())

    cave.putRock(6, 1)
    assertEquals(1, cave.top())

    cave.putRock(2, 4)
    assertEquals(4, cave.top())

    cave.putRock(6, 5)
    assertEquals(5, cave.top())

    cave.putRock(6, 1)
    assertEquals(5, cave.top())

    cave.putRock(6, 7)
    assertEquals(7, cave.top())
  }
}
