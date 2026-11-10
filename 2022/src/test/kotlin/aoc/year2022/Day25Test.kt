package aoc.year2022

import aoc.library.solvePart1
import aoc.year2022.Day25.SnafuNumber.Companion.toSnafuNumber
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day25Test {

  private val numberMapping = mapOf(
    "12111" to 906L,
    "1" to 1L,
    "1=-0-2" to 1747L,
    "0" to 0L,
  ).mapKeys { Day25.SnafuNumber(it.key) }

  @Test
  fun part1TestInput() {
    assertEquals(
      "2=-1=0",
      Day25.solvePart1(
        """
1=-0-2
12111
2=0=
21
2=01
111
20012
112
1=-1=
1-12
12
1=
122
        """.trimIndent(),
      ),
    )
  }

  @Test
  fun part1() {
    assertEquals("2=0--0---11--01=-100", Day25.solvePart1())
  }

  @Test
  fun snafuNumberToDecimal() {
    numberMapping.forEach { (snafuNumber, decimal) ->
      assertEquals(decimal, snafuNumber.toDecimal())
    }
  }

  @Test
  fun decimalToSnafuNumber() {
    numberMapping.forEach { (snafuNumber, decimal) ->
      assertEquals(snafuNumber, decimal.toSnafuNumber())
    }
  }
}
