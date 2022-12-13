package de.woitaschek.aoc.year2022

import de.woitaschek.aoc.utils.Puzzle
import java.util.*


object Day12 : Puzzle(2022, 12) {

  override fun solvePart1(input: String): Int {
    val vertexes = parseInput(input)
    return shortestDistanceToEndFrom(
      start = listOf(vertexes.flatten().first { it.isStart }),
      vertexes = vertexes,
    )
  }

  override fun solvePart2(input: String): Int {
    val vertexes = parseInput(input)
    return shortestDistanceToEndFrom(
      start = vertexes.flatten().filter { it.height == 0 },
      vertexes = vertexes,
    )
  }

  private fun shortestDistanceToEndFrom(start: List<Vertex>, vertexes: List<List<Vertex>>): Int {
    vertexes.flatten().forEach { it.reset() }
    fun vertex(x: Int, y: Int): Vertex? {
      return vertexes.getOrNull(y)?.getOrNull(x)
    }

    fun Vertex.neighborCandidates() = listOfNotNull(
      vertex(x - 1, y),
      vertex(x + 1, y),
      vertex(x, y - 1),
      vertex(x, y + 1),
    ).filter { neighbor ->
      height + 1 >= neighbor.height
    }

    val end = vertexes.flatten().first { it.isEnd }

    start.forEach { it.pathLength = 0 }

    val queue = PriorityQueue<Vertex>(compareBy { it.pathLength })
    queue.addAll(start)

    val result: Int
    while (true) {
      val vertex = queue.firstOrNull()
      if (vertex == null) {
        result = Int.MAX_VALUE
        break
      }
      if (vertex == end) {
        result = end.pathLength
        break
      }
      queue.remove(vertex)
      vertex.neighborCandidates().forEach { neighbor ->
        if (neighbor.pathLength == Int.MAX_VALUE) {
          neighbor.pathLength = vertex.pathLength + 1
          queue.add(neighbor)
        }
      }
    }
    return result
  }

  private data class Vertex(
    val x: Int,
    val y: Int,
    var pathLength: Int,
    val height: Int,
    val isStart: Boolean,
    val isEnd: Boolean,
  ) {
    fun reset() {
      pathLength = Int.MAX_VALUE
    }
  }


  private fun parseInput(input: String) = input.lines().filter(String::isNotEmpty)
    .mapIndexed { y, line ->
      line.mapIndexed { x, value ->
        val isStart = value == 'S'
        val isEnd = value == 'E'
        Vertex(
          x = x,
          y = y,
          pathLength = Int.MAX_VALUE,
          height = when {
            isStart -> 'a'
            isEnd -> 'z'
            else -> value
          } - 'a',
          isStart = isStart,
          isEnd = isEnd,
        )
      }
    }
}
