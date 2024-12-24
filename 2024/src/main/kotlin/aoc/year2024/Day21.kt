package aoc.year2024

import aoc.library.Direction
import aoc.library.Point
import aoc.library.Puzzle
import aoc.library.move
import java.util.PriorityQueue

object Day21 : Puzzle<Long, Long>(day = 21) {

  private const val UP = '^'
  private const val DOWN = 'v'
  private const val LEFT = '<'
  private const val RIGHT = '>'
  private const val ACTIVATE = 'A'

  /**
   *     +---+---+
   *     | ^ | A |
   * +---+---+---+
   * | < | v | > |
   * +---+---+---+
   */
  private val DIRECTIONAL_KEYPAD = mapOf(
    Point(1, 0) to UP,
    Point(2, 0) to ACTIVATE,
    Point(0, 1) to LEFT,
    Point(1, 1) to DOWN,
    Point(2, 1) to RIGHT,
  )

  /**
   * +---+---+---+
   * | 7 | 8 | 9 |
   * +---+---+---+
   * | 4 | 5 | 6 |
   * +---+---+---+
   * | 1 | 2 | 3 |
   * +---+---+---+
   *     | 0 | A |
   *     +---+---+
   */
  private val NUMERICAL_KEYPAD = mapOf(
    Point(0, 0) to '7',
    Point(1, 0) to '8',
    Point(2, 0) to '9',
    Point(0, 1) to '4',
    Point(1, 1) to '5',
    Point(2, 1) to '6',
    Point(0, 2) to '1',
    Point(1, 2) to '2',
    Point(2, 2) to '3',
    Point(0, 2) to '1',
    Point(1, 2) to '2',
    Point(2, 2) to '3',
    Point(1, 3) to '0',
    Point(2, 3) to ACTIVATE,
  )

  override fun solvePart1(input: String): Long {
    TODO()
  }

  private fun Map<Point, Char>.findChar(toFind: Char): Point = firstNotNullOf { (point, char) ->
    if (char == toFind) point else null
  }

  private fun findPath(
    pattern: Map<Point, Char>,
    from: Char,
    to: Char,
  ): String {
    val fromPosition = pattern.findChar(from)
    val toPosition = pattern.findChar(to)
    val visited = mutableSetOf<Point>()

    data class State(val position: Point, val steps: String)

    val queue = PriorityQueue<State>(compareBy { it.steps.length })
    queue.add(State(fromPosition, ""))
    while (true) {
      val candidate = queue.remove()
      if (candidate.position == toPosition) {
        return candidate.steps
      }
      if (!visited.add(candidate.position)) continue
      Direction.entries
        .forEach { direction ->
          val point = candidate.position.move(direction)
          if (point in pattern) {
            queue += State(point, candidate.steps + direction.arrow)
          }
        }
    }
  }

  override fun solvePart2(input: String): Long {
    TODO()
  }
}
