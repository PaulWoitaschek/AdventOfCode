package aoc.year2024

import aoc.library.Puzzle

object Day23 : Puzzle<Int, List<String>>(day = 23) {

  override fun solvePart1(input: String): Int {
    val connections = input.lines().map {
      it.split("-").toSet()
    }
    val candidates = connections.flatten().toSet().filter { it.startsWith("t") }

    val interConnectedTs = mutableSetOf<Set<String>>()

    fun connections(from: String): Set<String> = connections.filter { from in it }
      .map { it.single { it != from } }
      .toSet()

    candidates.forEach { a ->
      connections(a).forEach { b ->
        connections(b).forEach { c ->
          if (a in connections(c)) {
            interConnectedTs.add(setOf(a, b, c))
          }
        }
      }
    }
    //  println(interConnectedTs.filter { it.size == 3 }.joinToString("\n") { it.joinToString(",") })

    /**
     * ka-co
     * ta-co
     * de-co
     * ta-ka
     * de-ta
     * ka-de
     */

    return interConnectedTs.size // .count { it.size == 3 }
  }

  override fun solvePart2(input: String): List<String> {
    val connections = input.lines().map {
      it.split("-").toSet()
    }.toSet()

    var groups = connections
    var i = 1
    while (true) {
      println("iteration ${i++}")
      val newGroups = findConnectionGroups(connections, groups)
      println("have ${newGroups.size} groups")
      if (newGroups.size == 1) {
        return newGroups.single().sorted()
      } else {
        groups = newGroups
      }
    }
  }

  fun findConnectionGroups(
    connections: Set<Set<String>>,
    found: Set<Set<String>>,
  ): Set<Set<String>> {
    val connectionsCache = mutableMapOf<String, Set<String>>()
    fun connections(from: String): Set<String> = connectionsCache.getOrPut(from) {
      connections.filter { from in it }
        .map { it.single { it != from } }
        .toSet()
    }

    val allElements = connections.flatten().toSet()
    val new = mutableSetOf<Set<String>>()
    found.forEach { current ->
      allElements.forEach { candidate ->
        if (candidate !in current) {
          val shouldAdd = connections(candidate).containsAll(current)
          if (shouldAdd) {
            new += current + candidate
          }
        }
      }
    }
    return new
  }
}
