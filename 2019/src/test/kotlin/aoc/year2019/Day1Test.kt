package aoc.year2019

import aoc.library.solvePart1
import aoc.library.solvePart2
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day1Test {

  @Test
  fun part1() {
    assertEquals(3353880, Day1.solvePart1())
  }

  @Test
  fun part2() {
    assertEquals(5027950, Day1.solvePart2())
  }

  @Test
  fun fuelForMass() {
    mapOf(
      12 to 2,
      14 to 2,
      1969 to 654,
      100756 to 33583,
    ).forEach { (mass, fuel) ->
      assertEquals(fuel, Day1.fuelForMass(mass))
    }
  }

  @Test
  fun fuelForMassWithFuelTakingMass() {
    mapOf(
      14 to 2,
      1969 to 966,
      100756 to 50346,
    ).forEach { (mass, fuel) ->
      assertEquals(fuel, Day1.fuelForMassWithFuelTakingMass(mass))
    }
  }
}
