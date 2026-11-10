package aoc.year2022

import aoc.library.solvePart1
import aoc.library.solvePart2
import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class Day5Test {
  @Test
  fun day5() {
    assertEquals("SPFMVDTZT", Day5.solvePart1())
    assertEquals("ZFSJBPRFP", Day5.solvePart2())
  }
}
