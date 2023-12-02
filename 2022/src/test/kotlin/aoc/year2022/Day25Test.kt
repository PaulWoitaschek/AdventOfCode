package aoc.year2022

import aoc.utils.solvePart1
import aoc.utils.solvePart1WithTestInput
import aoc.year2022.Day25.SnafuNumber.Companion.toSnafuNumber
import io.kotest.assertions.assertSoftly
import io.kotest.assertions.withClue
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day25Test {

  private val numberMapping = mapOf(
    "12111" to 906L,
    "1" to 1L,
    "1=-0-2" to 1747L,
    "0" to 0L,
  ).mapKeys { Day25.SnafuNumber(it.key) }

  @Test
  fun test() {
    Day25.solvePart1() shouldBe "2=0--0---11--01=-100"
    Day25.solvePart1WithTestInput() shouldBe "2=-1=0"
  }

  @Test
  fun snafuNumberToDecimal() {
    assertSoftly {
      numberMapping.forEach { (snafuNumber, decimal) ->
        withClue("snafu=$snafuNumber, shouldBe decimal=$decimal") {
          snafuNumber.toDecimal() shouldBe decimal
        }
      }
    }
  }

  @Test
  fun decimalToSnafuNumber() {
    assertSoftly {
      numberMapping.forEach { (snafuNumber, decimal) ->
        withClue("snafu=$snafuNumber, shouldBe decimal=$decimal") {
          decimal.toSnafuNumber() shouldBe snafuNumber
        }
      }
    }
  }
}
