package aoc.year2025

import aoc.library.Point3
import aoc.library.Puzzle
import kotlin.math.pow
import kotlin.math.sqrt

class Day8(private val pairs: Int) : Puzzle<Long, Long>(day = 8) {
  override fun solvePart1(input: String): Long {
    val connections = parseAndFindConnections(input)
    val circuits = mutableListOf<MutableSet<Point3>>()

    connections.take(pairs)
      .forEach { connection ->
        formCircuit(circuits, connection)
      }

    reduceCircuit(circuits)

    return circuits.map { it.size.toLong() }
      .sortedDescending()
      .take(3)
      .reduce(Long::times)
  }

  private fun parseAndFindConnections(input: String): List<Connection> {
    val coordinates = input.lines()
      .map(Point3::parse)
    return coordinates.flatMapIndexed { i1, p1 ->
      coordinates.drop(i1 + 1).map { p2 ->
        Connection(p1, p2)
      }
    }.sortedBy { it.distance }
  }

  private fun formCircuit(
    circuits: MutableList<MutableSet<Point3>>,
    connection: Connection,
  ) {
    val existingTarget = circuits.firstOrNull {
      connection.a in it || connection.b in it
    }
    if (existingTarget == null) {
      circuits.add(mutableSetOf(connection.a, connection.b))
    } else {
      existingTarget.add(connection.a)
      existingTarget.add(connection.b)
    }
  }

  override fun solvePart2(input: String): Long {
    val connections = parseAndFindConnections(input)
    val pointSize = connections.flatMap { listOf(it.a, it.b) }.toSet().size
    val circuits = mutableListOf<MutableSet<Point3>>()
    connections.forEach { connection ->
      formCircuit(circuits, connection)
      reduceCircuit(circuits)
      if (circuits.first().size == pointSize) {
        return connection.a.x.toLong() * connection.b.x.toLong()
      }
    }

    error("")
  }

  private fun reduceCircuit(circuits: MutableList<MutableSet<Point3>>) {
    loop@ while (true) {
      circuits.forEachIndexed { i1, p1 ->
        circuits.forEachIndexed { i2, p2 ->
          if (i1 != i2 && p1.any { it in p2 }) {
            circuits.remove(p1)
            p2.addAll(p1)
            continue@loop
          }
        }
      }
      break
    }
  }

  private data class Connection(val a: Point3, val b: Point3) {
    val distance = sqrt(
      (a.x - b.x).toFloat().pow(2) +
        (a.y - b.y).toFloat().pow(2) +
        (a.z - b.z).toFloat().pow(2),
    ).toLong()
  }
}
