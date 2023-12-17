package aoc.year2023

import aoc.library.Direction
import aoc.library.Point
import aoc.library.Puzzle
import aoc.library.bounds
import aoc.library.move
import java.util.PriorityQueue

object Day17 : Puzzle<Int, Int>(day = 17) {

  override fun solvePart1(input: String): Int {
    val map = mutableMapOf<Point, Int>()
    input.lines().forEachIndexed { y, line ->
      line.forEachIndexed { x, char ->
        map[Point(x, y)] = char.digitToInt()
      }
    }
    val target = map.keys.maxBy { it.manhattanDistanceTo(Point.Zero) }
    val bounds = map.keys.bounds()
    val distanceComparator = compareByDescending<Flow> { Point.Zero.manhattanDistanceTo(it.position) }
    val heatComparator = compareBy<Flow> { it.heat }
    val comparator: Comparator<Flow> = distanceComparator.then(heatComparator)
    val queue = PriorityQueue(comparator)
    queue.add(Flow(Point.Zero, Direction.Right, 0, 0))
    var min = Int.MAX_VALUE

    val visited = mutableMapOf<Triple<Point, Direction, Int>, Int>()
    while (queue.isNotEmpty()) {
      val flow = queue.remove()
      if (flow.position == target) {
        if (flow.heat < min) {
          println("found a smaller heat with ${flow.heat}")
        }
        min = minOf(flow.heat, min)
        continue
      }

      val visitationState = Triple(flow.position, flow.direction, flow.stepsInDirection)
      val minHeatForKey = visited[visitationState]
      if (minHeatForKey != null && flow.heat >= minHeatForKey) {
        continue
      }
      visited[visitationState] = flow.heat

      if (flow.heat + flow.position.manhattanDistanceTo(target) >= min) continue

      Direction.entries
        .filter { it != flow.direction.opposite() }
        .filter {
          if (it == flow.direction) {
            flow.stepsInDirection < 3
          } else {
            true
          }
        }
        .forEach { direction ->
          val newPosition = flow.position.move(direction)
          if (newPosition in bounds) {
            queue.add(
              Flow(
                position = newPosition,
                direction = direction,
                heat = flow.heat + map[newPosition]!!,
                stepsInDirection = if (direction == flow.direction) flow.stepsInDirection + 1 else 1,
              ),
            )
          }
        }
    }
    return min
  }

  data class Flow(
    val position: Point,
    val direction: Direction,
    val stepsInDirection: Int,
    val heat: Int,
  )

  override fun solvePart2(input: String): Int {
    val map = mutableMapOf<Point, Int>()
    input.lines().forEachIndexed { y, line ->
      line.forEachIndexed { x, char ->
        map[Point(x, y)] = char.digitToInt()
      }
    }
    val target = map.keys.maxBy { it.manhattanDistanceTo(Point.Zero) }
    val bounds = map.keys.bounds()
    val distanceComparator = compareByDescending<Flow> { Point.Zero.manhattanDistanceTo(it.position) }
    val heatComparator = compareBy<Flow> { it.heat }
    val comparator: Comparator<Flow> = distanceComparator.then(heatComparator)
    val queue = PriorityQueue(comparator)
    queue.add(Flow(Point.Zero, Direction.Right, 0, 0))
    var min = Int.MAX_VALUE

    val visited = mutableMapOf<Triple<Point, Direction, Int>, Int>()
    while (queue.isNotEmpty()) {
      val flow = queue.remove()
      if (flow.position == target) {
        if (flow.heat < min) {
          println("found a smaller heat with ${flow.heat}")
        }
        min = minOf(flow.heat, min)
        continue
      }

      val visitationState = Triple(flow.position, flow.direction, flow.stepsInDirection)
      val minHeatForKey = visited[visitationState]
      if (minHeatForKey != null && flow.heat >= minHeatForKey) {
        continue
      }
      visited[visitationState] = flow.heat

      if (flow.heat + flow.position.manhattanDistanceTo(target) >= min) continue

      Direction.entries
        .filter { it != flow.direction.opposite() }
        .filter {
          if (it == flow.direction) {
            flow.stepsInDirection < 10
          } else {
            true
          }
        }
        .forEach { direction ->
          val sameDirection = direction == flow.direction
          if (sameDirection) {
            val newPosition = flow.position.move(direction)
            if (newPosition in bounds) {
              queue.add(
                Flow(
                  position = newPosition,
                  direction = direction,
                  heat = flow.heat + map[newPosition]!!,
                  stepsInDirection = flow.stepsInDirection + 1,
                ),
              )
            }
          } else {
            var newPosition = flow.position
            var heat = flow.heat
            repeat(4) {
              newPosition = newPosition.move(direction)
              heat += map[newPosition] ?: return@forEach
            }
            queue.add(
              Flow(
                position = newPosition,
                direction = direction,
                heat = heat,
                stepsInDirection = 4,
              ),
            )
          }
        }
    }
    return min
  }
}
