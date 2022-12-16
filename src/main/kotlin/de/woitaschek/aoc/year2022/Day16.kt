package de.woitaschek.aoc.year2022

import de.woitaschek.aoc.utils.Puzzle
import java.util.*

object Day16 : Puzzle(2022, 16) {

  override fun solvePart1(input: String): Any {
    val valves = input.lines().filter(String::isNotEmpty).map(Valve::parse)

    val distances = valves.associateWith { start ->
      valves.filter { it.flowRate > 0 }.associateWith { end ->
        shortestDistanceBetweenNodes(start, end, valves)
      }
    }

    val queue = mutableListOf(
      Travel(
        minutesRemaining = 30,
        opened = emptyList(),
        releasedSteam = 0,
        position = valves.first { it.name == "AA" },
      ),
    )
    var max = 0
    while (true) {
      val travel = queue.removeFirstOrNull() ?: break
      max = maxOf(travel.releasedSteam, max)
      if (travel.minutesRemaining <= 0) {
        continue
      }
      val valve = travel.position
      distances.getValue(valve)
        .mapNotNullTo(queue) { (candidate, distance) ->
          val minutesRemainingForTravel = travel.minutesRemaining - distance - 1
          if (minutesRemainingForTravel > 0 && candidate !in travel.opened) {
            Travel(
              minutesRemaining = minutesRemainingForTravel,
              opened = travel.opened + candidate,
              releasedSteam = travel.releasedSteam + candidate.flowRate * minutesRemainingForTravel,
              position = candidate,
            )
          } else {
            null
          }
        }
    }
    return max
  }

  override fun solvePart2(input: String): Any {
    TODO("Not yet implemented")
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

  data class Travel(
    val minutesRemaining: Int,
    val opened: List<Valve>,
    val releasedSteam: Int,
    val position: Valve,
  )

  data class Valve(
    val name: String,
    val flowRate: Int,
    val tunnelsTo: Set<String>,
  ) {
    companion object {
      private val regex = "Valve (\\w+) has flow rate=(\\d+); tunnels? leads? to valves? (.*)".toRegex()
      fun parse(input: String): Valve {
        val parsed = regex.find(input)!!.destructured.toList()
        return Valve(
          name = parsed[0],
          flowRate = parsed[1].toInt(),
          tunnelsTo = parsed[2].split(", ").toSet(),
        )
      }
    }
  }
}
