package de.woitaschek.aoc.year2022

import de.woitaschek.aoc.utils.Puzzle

object Day18 : Puzzle(2022, 18) {

  override fun solvePart1(input: String): Int {
    val lava = parseInput(input)
    return lava.sumOf { cube ->
      cube.adjacent().count { it !in lava }
    }
  }

  override fun solvePart2(input: String) = TODO()

  data class Cube(val x: Int, val y: Int, val z: Int) {
    fun adjacent() = listOf(
      copy(x = x + 1),
      copy(x = x - 1),
      copy(y = y + 1),
      copy(y = y - 1),
      copy(z = z + 1),
      copy(z = z - 1),
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
