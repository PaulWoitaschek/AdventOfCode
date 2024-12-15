package aoc.year2024

import aoc.library.Direction
import aoc.library.grid
import aoc.library.printString
import aoc.library.solvePart1
import aoc.library.solvePart2
import io.kotest.matchers.longs.shouldBeExactly
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class Day15Test {

  @Test
  fun `robot does not move when next to rock`() {
    testWalk(
      start = "@#",
      expected = "@#",
      direction = Direction.Right,
    )
  }

  @Test
  fun `robot walks to empty spot`() {
    testWalk(
      start = "@.#",
      expected = ".@#",
      direction = Direction.Right,
    )
  }

  @Test
  fun `pushes boxes to empty spot`() {
    testWalk("@OO.#", ".@OO#", Direction.Right)
  }

  @Test
  fun `does not push box against wall`() {
    testWalk(start = "@O#", expected = "@O#", direction = Direction.Right)
  }

  private fun testWalk(
    start: String,
    expected: String,
    direction: Direction,
  ) {
    Day15
      .walk(
        map = grid(start),
        direction = direction,
      )
      .printString(renderWalls = false)
      .shouldBe(
        grid(expected).printString(renderWalls = false),
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
