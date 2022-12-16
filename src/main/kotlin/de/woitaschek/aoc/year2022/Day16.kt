package de.woitaschek.aoc.year2022

import de.woitaschek.aoc.utils.Puzzle
import java.util.*

object Day16 : Puzzle(2022, 16) {

  override fun solvePart1(input: String): Int = solve(input = input, availableMinutes = 30, withElephant = false)

  override fun solvePart2(input: String): Int = solve(input = input, availableMinutes = 26, withElephant = true)

  private fun solve(input: String, availableMinutes: Int, withElephant: Boolean): Int {
    val valves = input.lines().filter(String::isNotEmpty).map(Valve::parse)
      .sortedByDescending { it.flowRate }

    val distances = valves.associateWith { start ->
      valves.filter { it.flowRate > 0 }.associateWith { end ->
        shortestDistanceBetweenNodes(start, end, valves)
      }
    }

    val startValve = valves.first { it.name == "AA" }

    var maxPressureReleased = 0

    fun search(releasedPressure: Int, position: Valve, visited: Set<Valve>, minute: Int, spawnElephant: Boolean) {
      maxPressureReleased = maxOf(releasedPressure, maxPressureReleased)

      if (!spawnElephant) {
        val unVisited = (valves - visited)
        var index = 0
        val possiblePressureRelease = (availableMinutes - minute downTo 0 step 2).sumOf {
          (unVisited.getOrNull(index++)?.flowRate ?: 0) * it
        }
        if (possiblePressureRelease + releasedPressure < maxPressureReleased) return
      }

      distances.getValue(position).forEach { (candidate, distance) ->
        val newMinute = minute + distance + 1
        if (newMinute < availableMinutes && candidate !in visited) {
          search(
            releasedPressure = releasedPressure + (availableMinutes - newMinute) * candidate.flowRate,
            position = candidate,
            visited = visited + candidate,
            minute = newMinute,
            spawnElephant = spawnElephant,
          )
        }
      }
      if (spawnElephant) {
        search(
          releasedPressure = releasedPressure,
          position = startValve,
          visited = visited,
          minute = 0,
          spawnElephant = false,
        )
      }
    }

    search(
      releasedPressure = 0,
      position = startValve,
      visited = emptySet(),
      minute = 0,
      spawnElephant = withElephant,
    )

    return maxPressureReleased
  }

  private fun shortestDistanceBetweenNodes(
    from: Valve,
    to: Valve,
    all: List<Valve>,
  ): Int {
    data class Node(val valve: Valve, var distance: Int = Int.MAX_VALUE)

    val allNodes = all.map(::Node).associateBy { it.valve.name }
    val startNode = allNodes.getValue(from.name)
    val endNode = allNodes.getValue(to.name)

    val queue = PriorityQueue<Node>(compareBy { it.distance })
    startNode.distance = 0
    queue.add(startNode)

    while (true) {
      val node = queue.remove()!!
      if (node == endNode) {
        return endNode.distance
      }
      node.valve.tunnelsTo.mapNotNullTo(queue) { valveName ->
        val child = allNodes.getValue(valveName)
        if (child.distance == Int.MAX_VALUE) {
          child.distance = node.distance + 1
          child
        } else {
          null
        }
      }
    }
  }

  private data class Valve(
    val name: String,
    val flowRate: Int,
    val tunnelsTo: Set<String>,
  ) {
    companion object {
      private val regex = "Valve (\\w+) has flow rate=(\\d+); tunnels? leads? to valves? (.*)".toRegex()
      fun parse(input: String): Valve {
        val (name, flowRate, tunnelsTo) = regex.find(input)!!.destructured
        return Valve(
          name = name,
          flowRate = flowRate.toInt(),
          tunnelsTo = tunnelsTo.split(", ").toSet(),
        )
      }
    }
  }
}
