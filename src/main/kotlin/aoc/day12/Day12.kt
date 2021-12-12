package aoc.day12

import aoc.Puzzle

object Day12 : Puzzle {

  override val day = 12

  override fun solvePart1(input: String): Long {
    return Passage.parse(input, allowTwoSmallCaves = false).pathsCount()
  }

  override fun solvePart2(input: String): Long {
    return Passage.parse(input, allowTwoSmallCaves = true).pathsCount()
  }
}

private data class Passage(
  private val connections: List<Connection>,
  private val allowTwoSmallCaves: Boolean
) {

  fun pathsCount(): Long {
    return findPaths().size.toLong()
  }

  private fun findPaths(): List<List<Segment>> {
    return mutableListOf<List<Segment>>()
      .also { collectPaths(result = it, currentRoute = listOf(Segment.Start)) }
  }

  private fun collectPaths(result: MutableList<List<Segment>>, currentRoute: List<Segment>) {
    validConnections(currentRoute = currentRoute).forEach { to ->
      val newRoute = currentRoute + to
      if (to == Segment.End) {
        result += newRoute
      } else {
        collectPaths(result = result, currentRoute = newRoute)
      }
    }
  }

  private fun validConnections(currentRoute: List<Segment>): List<Segment> {
    return connections
      .mapNotNull { connection ->
        connection.connectionTo(currentRoute.last())
          .takeUnless { it == Segment.Start }
          ?.takeIf { to ->
            if (to is Segment.Cave && to.isSmallCave) {
              if (!allowTwoSmallCaves || currentRoute.hasDuplicatedSmallCaves()) {
                to !in currentRoute
              } else {
                true
              }
            } else {
              true
            }
          }
      }
  }

  private fun List<Segment>.hasDuplicatedSmallCaves(): Boolean {
    val smallCaves = filter { it is Segment.Cave && it.isSmallCave }
    return smallCaves.toSet().size != smallCaves.size
  }

  companion object {
    fun parse(input: String, allowTwoSmallCaves: Boolean): Passage {
      return Passage(
        connections = input.lines().map(Connection.Companion::parse),
        allowTwoSmallCaves = allowTwoSmallCaves
      )
    }
  }
}

private sealed interface Segment {

  object Start : Segment {
    override fun toString(): String = "Start"
  }

  data class Cave(val name: String) : Segment {
    val isSmallCave: Boolean = name.all(Char::isLowerCase)
  }

  object End : Segment {
    override fun toString(): String = "End"
  }

  companion object {
    fun parse(value: String): Segment {
      return when (value) {
        "start" -> Start
        "end" -> End
        else -> Cave(value)
      }
    }
  }
}

private data class Connection(
  val from: Segment,
  val to: Segment
) {

  fun connectionTo(segment: Segment): Segment? {
    return when (segment) {
      from -> to
      to -> from
      else -> null
    }
  }

  companion object {
    fun parse(input: String): Connection {
      val (from, to) = input.split("-")
      return Connection(
        from = Segment.parse(from),
        to = Segment.parse(to),
      )
    }
  }
}
