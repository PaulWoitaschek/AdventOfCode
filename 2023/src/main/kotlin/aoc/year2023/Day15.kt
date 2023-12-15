package aoc.year2023

import aoc.library.Puzzle

object Day15 : Puzzle<Int, Int>(day = 15) {

  override fun solvePart1(input: String): Int = input.split(",").sumOf(::hash)

  override fun solvePart2(input: String): Int {
    return distributeLenses(input).toList()
      .sumOf { (boxNumber, box) ->
        box.toList().withIndex().sumOf {
          val slotNumber = it.index + 1
          val focalLength = it.value.second
          focalLength * slotNumber * (boxNumber + 1)
        }
      }
  }

  private fun distributeLenses(input: String): Map<Int, Map<String, Int>> {
    val values = input.split(",")
    val boxes = mutableMapOf<Int, MutableMap<String, Int>>()
    values
      .forEach { value ->
        val (label, right) = value.split('=', '-')
        val boxNumber = hash(label)
        if (right.isNotEmpty()) {
          // equals
          val box = boxes.getOrPut(boxNumber) { mutableMapOf() }
          val focalLength = right.toInt()
          box[label] = focalLength
        } else {
          // dash
          val box = boxes.getOrPut(boxNumber) { mutableMapOf() }
          box.remove(label)
        }
      }
    return boxes
  }

  fun hash(code: String): Int = code.fold(0) { value, char ->
    (value + char.code) * 17 % 256
  }
}
