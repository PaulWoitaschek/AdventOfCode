package de.woitaschek.aoc.year2022

import de.woitaschek.aoc.utils.Direction
import de.woitaschek.aoc.utils.Point
import de.woitaschek.aoc.utils.Puzzle
import java.util.*

object Day24 : Puzzle(2022, 24) {

  override fun solvePart1(input: String): Int {
    val world = World.parse(input)

    val queue = PriorityQueue<Journey>(compareBy({ it.position.manhattanDistanceTo(world.end) }, { it.minute }))

    queue.add(Journey(1, position = world.start))

    val visited = mutableSetOf<Journey>()

    var fastestPath = Int.MAX_VALUE

    while (queue.isNotEmpty()) {
      val journey = queue.remove()

      if (!visited.add(journey)) continue

      if (journey.minute >= fastestPath) {
        continue
      }
      if (journey.minute + journey.position.manhattanDistanceTo(world.end) >= fastestPath) {
        continue
      }
      if (journey.position == world.end) {
        fastestPath = minOf(fastestPath, journey.minute)
        continue
      }

      val blizzards = world.blizzardsAt(journey.minute + 1)
      val position = journey.position
      listOf(
        position,
        position.copy(x = position.x - 1),
        position.copy(x = position.x + 1),
        position.copy(y = position.y - 1),
        position.copy(y = position.y + 1),
      ).filter {
        it == world.end || ((it.x in 0 until world.width) && (it.y in 0 until world.height) && it !in blizzards)
      }.map {
        Journey(journey.minute + 1, it)
      }.let { queue.addAll(it) }
    }

    return fastestPath
  }

  override fun solvePart2(input: String): Any {
    TODO("Not yet implemented")
  }

  data class Journey(
    val minute: Int,
    val position: Point,
  )

  data class World(
    val width: Int,
    val height: Int,
    val blizzards: List<Blizzard>,
    val start: Point,
    val end: Point,
  ) {

    private val blizzardCache = mutableMapOf<Int, List<Point>>()

    fun blizzardsAt(minute: Int): List<Point> = blizzardCache.getOrPut(minute) {
      blizzards.map { blizzard ->
        when (blizzard.direction) {
          Direction.Left -> blizzard.point.copy(x = ((blizzard.point.x - minute).mod(width)))
          Direction.Right -> blizzard.point.copy(x = ((blizzard.point.x + minute).mod(width)))
          Direction.Up -> blizzard.point.copy(y = ((blizzard.point.y - minute).mod(height)))
          Direction.Down -> blizzard.point.copy(y = ((blizzard.point.y + minute).mod(height)))
        }
      }
    }

    companion object {
      fun parse(input: String): World {
        val lines = input.lines().filter { it.isNotEmpty() }
        val width = lines.first().length - 2
        val height = lines.size - 2

        val blizzards = mutableListOf<Blizzard>()
        lines.drop(1)
          .dropLast(1)
          .forEachIndexed { y, line ->
            line.drop(1).dropLast(1)
              .forEachIndexed { x, c ->
                val direction = when (c) {
                  '<' -> Direction.Left
                  '>' -> Direction.Right
                  '^' -> Direction.Up
                  'v' -> Direction.Down
                  else -> null
                }
                if (direction != null) {
                  blizzards += Blizzard(Point(x, y), direction)
                }
              }
          }

        val start = Point(0, -1)
        val end = Point(width - 1, height)
        return World(
          width = width,
          height = height,
          blizzards = blizzards,
          start = start,
          end = end,
        )
      }
    }
  }

  data class Blizzard(
    val point: Point,
    val direction: Direction,
  )
}
