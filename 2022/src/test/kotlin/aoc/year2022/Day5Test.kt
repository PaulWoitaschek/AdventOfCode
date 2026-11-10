package aoc.year2022

import aoc.library.solvePart1
import aoc.library.solvePart2
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day5Test {
  @Test
  fun day5() {
    assertEquals("SPFMVDTZT", Day5.solvePart1())
    assertEquals("ZFSJBPRFP", Day5.solvePart2())
  }
}
