package aoc.year2024

import aoc.library.Direction
import aoc.library.Point
import aoc.library.Puzzle
import aoc.library.grid
import aoc.library.move
import java.util.PriorityQueue

object Day16 : Puzzle<Int, Int>(day = 16) {

  private const val WALL = '#'
  private const val END = 'E'
  private const val REINDEER = 'S'
  private const val TURN_PRICE = 1000
  private const val WALK_PRICE = 1

  override fun solvePart1(input: String): Int {
    val grid = grid(input)
    val reindeer = grid.filterValues { it == REINDEER }.keys.single()

    data class State(val position: Point, val facing: Direction, val score: Int)

    val queue = PriorityQueue<State>(compareBy { it.score })
    var minScore = Int.MAX_VALUE
    queue.add(State(reindeer, Direction.Right, 0))
    val seen = mutableSetOf<Point>()
    while (queue.isNotEmpty()) {
      val state = queue.remove()
      if (!seen.add(state.position)) {
        continue
      }
      if (state.score >= minScore) continue
      val value = grid.getValue(state.position)
      if (value == WALL) continue
      if (value == END) {
        minScore = minOf(minScore, state.score)
        continue
      }
      queue += listOf(
        State(
          position = state.position.move(state.facing),
          facing = state.facing,
          score = state.score + WALK_PRICE,
        ),
        State(
          position = state.position.move(state.facing.clockwise()),
          facing = state.facing.clockwise(),
          score = state.score + TURN_PRICE + WALK_PRICE,
        ),
        State(
          position = state.position.move(state.facing.counterClockwise()),
          facing = state.facing.counterClockwise(),
          score = state.score + TURN_PRICE + WALK_PRICE,
        ),
      )
    }

    return minScore
  }

  override fun solvePart2(input: String): Int {
    val grid = grid(input)
    val reindeer = grid.filterValues { it == REINDEER }.keys.single()

    data class State(val position: Point, val facing: Direction, val score: Int, val path: List<Point>)

    val queue = mutableListOf<State>()
    var minScore = solvePart1(input)
    queue.add(State(reindeer, Direction.Right, 0, listOf(reindeer)))
    val seen = mutableMapOf<Pair<Point, Direction>, Int>()
    val bestPathsPoints = mutableSetOf<Point>()
    while (queue.isNotEmpty()) {
      val state = queue.removeFirst()

      val lastVisitScore = seen[state.position to state.facing]
      if (lastVisitScore == null) {
        seen[state.position to state.facing] = state.score
      } else {
        if (lastVisitScore < state.score) {
          continue
        }
      }
      if (state.score > minScore) continue
      val value = grid.getValue(state.position)
      if (value == WALL) continue
      if (value == END) {
        if (state.score < minScore) {
          bestPathsPoints.clear()
        }
        minScore = minOf(minScore, state.score)
        bestPathsPoints += state.path
        continue
      }
      queue += listOf(
        State(
          position = state.position.move(state.facing),
          facing = state.facing,
          score = state.score + WALK_PRICE,
          path = state.path + state.position.move(state.facing),
        ),
        State(
          position = state.position.move(state.facing.clockwise()),
          facing = state.facing.clockwise(),
          score = state.score + TURN_PRICE + WALK_PRICE,
          path = state.path + state.position.move(state.facing.clockwise()),
        ),
        State(
          position = state.position.move(state.facing.counterClockwise()),
          facing = state.facing.counterClockwise(),
          score = state.score + TURN_PRICE + WALK_PRICE,
          path = state.path + state.position.move(state.facing.counterClockwise()),
        ),
      )
    }

    return bestPathsPoints.size
  }
}
