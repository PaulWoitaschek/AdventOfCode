package de.woitaschek.aoc.year2022

import de.woitaschek.aoc.utils.Puzzle

object Day18 : Puzzle(2022, 18) {

  override fun solvePart1(input: String): Int {
    val lava = parseInput(input)
    return lava.sumOf { cube ->
      cube.adjacent().count { it !in lava }
    }
  }

  override fun solvePart2(input: String): Any {
    val lava = parseInput(input)
    val xRange = lava.minOf { it.x - 1 }..lava.maxOf { it.x + 1 }
    val yRange = lava.minOf { it.y - 1 }..lava.maxOf { it.y + 1 }
    val zRange = lava.minOf { it.z - 1 }..lava.maxOf { it.z + 1 }

    val air = mutableSetOf<Cube>()
    fun visit(cube: Cube) {
      air.add(cube)
      cube.adjacent()
        .filter { it !in air && it.x in xRange && it.y in yRange && it.z in zRange && it !in lava }
        .forEach(::visit)
    }
    visit(Cube(xRange.first, yRange.first, zRange.first))
    return air.sumOf { airCube ->
      airCube.adjacent().count { neighbor ->
        neighbor in lava
      }
    }
  }

  data class Cube(val x: Int, val y: Int, val z: Int) {
    fun adjacent() = listOf(
      copy(x = x + 1), copy(x = x - 1),
      copy(y = y + 1), copy(y = y - 1),
      copy(z = z + 1), copy(z = z - 1),
    )

    override fun toString(): String = "($x,$y,$z)"

    companion object {
      fun parse(input: String): Cube {
        val (x, y, z) = input.split(",").map(String::toInt)
        return Cube(x, y, z)
      }
    }
  }

  private fun parseInput(input: String): List<Cube> = input.lines().filter(String::isNotEmpty).map(Cube::parse)
}
