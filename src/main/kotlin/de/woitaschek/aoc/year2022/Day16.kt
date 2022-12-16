package de.woitaschek.aoc.year2022

import de.woitaschek.aoc.utils.Puzzle
import java.util.*

object Day16 : Puzzle(2022, 16) {

  override fun solvePart1(input: String): Any {
    val valves = input.lines().filter(String::isNotEmpty).map(Valve::parse)

    val distances = valves.associate { start ->
      start.name to (valves.filter { it.flowRate > 0 })
        .associate { end ->
          end.name to shortestDistanceBetweenNodes(start, end, valves)
        }
    }

    val valvesByName = valves.associateBy { it.name }
    fun valve(name: String): Valve = valvesByName.getValue(name)

    val queue = mutableListOf(
      Travel(
        minutesRemaining = 30,
        opened = emptyList(),
        releasedSteam = 0,
        position = "AA",
      ),
    )
    var max = 0
    while (true) {
      val travel = queue.removeFirstOrNull() ?: break
      max = maxOf(travel.releasedSteam, max)
      if (travel.minutesRemaining <= 0) {
        continue
      }
      val valve = valve(travel.position)
      distances.getValue(valve.name)
        .mapNotNullTo(queue) { (candidateName, distance) ->
          val candidate = valve(candidateName)
          val minutesRemainingForTravel = travel.minutesRemaining - distance - 1
          if (minutesRemainingForTravel > 0 && candidateName !in travel.opened) {
            Travel(
              minutesRemaining = minutesRemainingForTravel,
              opened = travel.opened + candidateName,
              releasedSteam = travel.releasedSteam + candidate.flowRate * minutesRemainingForTravel,
              position = candidateName,
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

    val allNodes = all.map { Node(it) }
    fun node(name: String): Node = allNodes.single { it.valve.name == name }
    val startNode = node(from.name)
    val endNode = node(to.name)

    val queue = PriorityQueue<Node>(compareBy { it.distance })
    startNode.distance = 0
    queue.add(startNode)

    fun Node.neighbors(): List<Node> = valve.tunnelsTo.map { childName ->
      node(childName)
    }

    while (true) {
      val node = queue.remove()
      if (node == endNode) {
        return endNode.distance
      }
      node.neighbors().mapNotNullTo(queue) { child ->
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
    val opened: List<String>,
    val releasedSteam: Int,
    val position: String,
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