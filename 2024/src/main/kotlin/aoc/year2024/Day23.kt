package aoc.year2024

import aoc.library.Puzzle

object Day23 : Puzzle<Int, List<String>>(day = 23) {

  override fun solvePart1(input: String): Int {
    val lanPartyFinder = LanPartyFinder.parse(input)
    val connectionsWithT = lanPartyFinder.connections.filter { connection ->
      connection.any { it.startsWith("t") }
    }.toSet()
    return lanPartyFinder.addMoreConnections(connectionsWithT).size
  }

  override fun solvePart2(input: String): List<String> {
    val lanPartyFinder = LanPartyFinder.parse(input)

    var groups = lanPartyFinder.connections
    while (true) {
      val newGroups = lanPartyFinder.addMoreConnections(groups)
      if (newGroups.size == 1) {
        return newGroups.single().sorted()
      } else {
        groups = newGroups
      }
    }
  }

  private class LanPartyFinder(val connections: Set<Set<String>>) {

    private val connectionsCache = mutableMapOf<String, Set<String>>()
    fun connections(from: String): Set<String> = connectionsCache.getOrPut(from) {
      connections.filter { from in it }
        .map { elements -> elements.first { it != from } }
        .toSet()
    }

    fun addMoreConnections(found: Set<Set<String>>): Set<Set<String>> = found.flatMap { current ->
      current.asSequence().flatMap { connections(it) }.distinct()
        .filter { it !in current }
        .filter { connections(it).containsAll(current) }
        .map { candidate ->
          current + candidate
        }
    }.toSet()

    companion object {
      fun parse(input: String): LanPartyFinder {
        val connections = input.lines().map {
          it.split("-").toSet()
        }.toSet()
        return LanPartyFinder(connections)
      }
    }
  }
}
