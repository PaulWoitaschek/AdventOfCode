package aoc.year2024

import aoc.library.Direction
import aoc.library.Point
import aoc.library.solvePart1
import aoc.library.solvePart2
import io.kotest.matchers.longs.shouldBeExactly
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class Day15Test {

  @Test
  fun `robot does not move when next to rock`() {
    val map = mapOf(
      Point(0, 0) to Day15.Tile.Robot,
      Point(1, 0) to Day15.Tile.Wall,
    )
    map.walk(Direction.Right) shouldBe map
  }

  @Test
  fun `robot walks to empty spot`() {
    val map = mapOf(
      Point(0, 0) to Day15.Tile.Robot,
      Point(2, 0) to Day15.Tile.Wall,
    )
    map.walk(Direction.Right) shouldBe mapOf(
      Point(1, 0) to Day15.Tile.Robot,
      Point(2, 0) to Day15.Tile.Wall,
    )
  }

  @Test
  fun `pushes boxes to empty spot`() {
    val map = mapOf(
      Point(0, 0) to Day15.Tile.Robot,
      Point(1, 0) to Day15.Tile.Box,
      Point(2, 0) to Day15.Tile.Box,
      Point(4, 0) to Day15.Tile.Wall,
    )
    map.walk(Direction.Right) shouldBe mapOf(
      Point(1, 0) to Day15.Tile.Robot,
      Point(2, 0) to Day15.Tile.Box,
      Point(3, 0) to Day15.Tile.Box,
      Point(4, 0) to Day15.Tile.Wall,
    )
  }

  @Test
  fun `does not push box against wall`() {
    val map = mapOf(
      Point(0, 0) to Day15.Tile.Robot,
      Point(1, 0) to Day15.Tile.Box,
      Point(2, 0) to Day15.Tile.Wall,
    )
    map.walk(Direction.Right) shouldBe mapOf(
      Point(0, 0) to Day15.Tile.Robot,
      Point(1, 0) to Day15.Tile.Box,
      Point(2, 0) to Day15.Tile.Wall,
    )
  }

  @Test
  fun part1TestInput1() {
    Day15.solvePart1(
      """
      ########
      #..O.O.#
      ##@.O..#
      #...O..#
      #.#.O..#
      #...O..#
      #......#
      ########

      <^^>>>vv<v>>v<<
      """.trimIndent(),
    ) shouldBeExactly 2028
  }

  @Test
  fun part1TestInput2() {
    Day15.solvePart1(
"""
  ##########
  #..O..O.O#
  #......O.#
  #.OO..O.O#
  #..O@..O.#
  #O#..O...#
  #O..O..O.#
  #.OO.O.OO#
  #....O...#
  ##########

  <vv>^<v^>v>^vv^v>v<>v^v<v<^vv<<<^><<><>>v<vvv<>^v^>^<<<><<v<<<v^vv^v>^
  vvv<<^>^v^^><<>>><>^<<><^vv^^<>vvv<>><^^v>^>vv<>v<<<<v<^v>^<^^>>>^<v<v
  ><>vv>v^v^<>><>>>><^^>vv>v<^^^>>v^v^<^^>v^^>v^<^v>v<>>v^v^<v>v^^<^^vv<
  <<v<^>>^^^^>>>v^<>vvv^><v<<<>^^^vv^<vvv>^>v<^^^^v<>^>vvvv><>>v^<<^^^^^
  ^><^><>>><>^^<<^^v>>><^<v>^<vv>>v>>>^v><>^v><<<<v>>v<v<v>vvv>^<><<>^><
  ^>><>^v<><^vvv<^^<><v<<<<<><^v<<<><<<^^<v<^^^><^>>^<v^><<<^>>^v<v^v<v^
  >^>>^v>vv>^<<^v<>><<><<v<<v><>v<^vv<<<>^^v^>^^>>><<^v>>v^v><^^>>^<>vv^
  <><^^>^^^<><vvvvv^v<v<<>^v<v>v<<^><<><<><<<^^<<<^<<>><<><^^^>^^<>^>v<>
  ^^>vv<^v^v<vv>^<><v<^v>^^^>>>^^vvv^>vvv<>>>^<^>>>>>^<<^v>^vvv<>^<><<v>
  v^^>>><<^^<>>^v^<v^vv<>v^<<>^<^v^v><^<<<><<^<v><v<>vv>>v><v^<vv<>v^<<^
""".trimIndent(),
    ) shouldBeExactly 10092
  }

  @Test
  fun part1() {
    Day15.solvePart1() shouldBeExactly 1360570
  }

  @Test
  @Disabled
  fun part2TestInput() {
    Day15.solvePart2() shouldBeExactly 42
  }

  @Test
  @Disabled
  fun part2() {
    Day15.solvePart2() shouldBeExactly 42
  }
}
