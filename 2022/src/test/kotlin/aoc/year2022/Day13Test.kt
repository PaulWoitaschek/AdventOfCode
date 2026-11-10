package aoc.year2022

import aoc.library.solvePart1
import aoc.library.solvePart2
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day13Test {

  @Test
  fun part1TestInput() {
    assertEquals(
      13,
      Day13.solvePart1(
        """
[1,1,3,1,1]
[1,1,5,1,1]

[[1],[2,3,4]]
[[1],4]

[9]
[[8,7,6]]

[[4,4],4,4]
[[4,4],4,4,4]

[7,7,7,7]
[7,7,7]

[]
[3]

[[[]]]
[[]]

[1,[2,[3,[4,[5,6,7]]]],8,9]
[1,[2,[3,[4,[5,6,0]]]],8,9]
        """.trimIndent(),
      ),
    )
  }

  @Test
  fun part1() {
    assertEquals(6568, Day13.solvePart1())
  }

  @Test
  fun part2Test() {
    assertEquals(
      140,
      Day13.solvePart2(
        """
[1,1,3,1,1]
[1,1,5,1,1]

[[1],[2,3,4]]
[[1],4]

[9]
[[8,7,6]]

[[4,4],4,4]
[[4,4],4,4,4]

[7,7,7,7]
[7,7,7]

[]
[3]

[[[]]]
[[]]

[1,[2,[3,[4,[5,6,7]]]],8,9]
[1,[2,[3,[4,[5,6,0]]]],8,9]
        """.trimIndent(),
      ),
    )
  }

  @Test
  fun part2() {
    assertEquals(19493, Day13.solvePart2())
  }
}
