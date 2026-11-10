package aoc.library

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LcmTest {

  @Test
  fun `lcm of 3 and 4`() {
    assertEquals(12, lcm(listOf(3, 4)))
  }

  @Test
  fun `lcm of prime numbers 5 and 7`() {
    assertEquals(35, lcm(listOf(5, 7)))
  }

  @Test
  fun `lcm of a single number 9`() {
    assertEquals(9, lcm(listOf(9)))
  }

  @Test
  fun `lcm of 6 and 8 with common factor`() {
    assertEquals(24, lcm(listOf(6, 8)))
  }

  @Test
  fun `lcm of multiple numbers 4, 6, 8`() {
    assertEquals(24, lcm(listOf(4, 6, 8)))
  }

  @Test
  fun `lcm of large numbers 20 and 30`() {
    assertEquals(60, lcm(listOf(20, 30)))
  }

  @Test
  fun `lcm of 1 and 11`() {
    assertEquals(11, lcm(listOf(1, 11)))
  }

  @Test
  fun `lcm with zero included`() {
    assertEquals(0, lcm(listOf(0, 5)))
  }

  @Test
  fun `lcm of negative and positive numbers -3 and 4`() {
    assertEquals(12, lcm(listOf(-3, 4)))
  }
}
