package de.woitaschek.aoc.year2019

import de.woitaschek.aoc.utils.Puzzle
import de.woitaschek.aoc.utils.toLineSeparatedIntList

object Day1 : Puzzle<Int, Int>(2019, 1) {

  override fun solvePart1(input: String): Int = input.toLineSeparatedIntList().sumOf { fuelForMass(it) }
  override fun solvePart2(input: String): Int = input.toLineSeparatedIntList().sumOf { fuelForMassWithFuelTakingMass(it) }

  fun fuelForMass(mass: Int): Int = mass / 3 - 2

  fun fuelForMassWithFuelTakingMass(mass: Int): Int {
    if (mass < 0) return 0
    val fuelForMass = fuelForMass(mass)
    return fuelForMass + fuelForMassWithFuelTakingMass(fuelForMass)
      .coerceAtLeast(0)
  }
}
