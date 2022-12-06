package de.woitaschek.aoc.year2021

import de.woitaschek.aoc.utils.Puzzle
import de.woitaschek.aoc.utils.Point

object Day11 : Puzzle(2021, 11) {

  override fun solvePart1(input: String): Long {
    return generateSequence(Octopuses.parse(input)) { it.afterOneDay() }
      .take(101)
      .last()
      .flashes
  }

  override fun solvePart2(input: String): Long {
    return generateSequence(Octopuses.parse(input)) { it.afterOneDay() }
      .windowed(2)
      .takeWhile { (previous, current) ->
        previous.flashes + previous.octopuses.size != current.flashes
      }
      .count()
      .toLong() + 1
  }
}

private data class Octopus(val point: Point, val energyLevel: Int, val flashes: Int)

private data class Octopuses(val octopuses: List<Octopus>) {

  val flashes: Long = octopuses.sumOf { it.flashes.toLong() }

  fun afterOneDay(): Octopuses {
    val afterEnergyIncrease = octopuses.map { it.copy(energyLevel = it.energyLevel + 1) }

    val result = afterEnergyIncrease.toMutableList()
    val flashed = mutableSetOf<Point>()
    while (true) {
      val flashingPoints = result.filter { it.point !in flashed && it.energyLevel > 9 }.map { it.point }
      if (flashingPoints.isEmpty()) break

      flashed.addAll(flashingPoints)

      flashingPoints.flatMap { it.adjacent(includeDiagonal = true) }.forEach { adjacentPoint ->
        val octopus = result.find { it.point == adjacentPoint }
        if (octopus != null) {
          result[result.indexOf(octopus)] = octopus.copy(energyLevel = octopus.energyLevel + 1)
        }
      }
    }

    val afterFlashing = result.map {
      if (it.energyLevel > 9) {
        it.copy(energyLevel = 0, flashes = it.flashes + 1)
      } else {
        it
      }
    }

    return Octopuses(afterFlashing)
  }

  companion object {
    fun parse(input: String): Octopuses {
      return Octopuses(
        octopuses = input.lines()
          .flatMapIndexed { y, line ->
            line.mapIndexed { x, value ->
              Octopus(
                point = Point(x = x, y = y),
                energyLevel = value.digitToInt(),
                flashes = 0,
              )
            }
          },
      )
    }
  }
}

