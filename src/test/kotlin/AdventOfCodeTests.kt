import io.kotest.matchers.shouldBe
import org.junit.Test

class AdventOfCodeTests {

  @Test
  fun day1() {
    day1(input(1)) shouldBe 7
  }

  @Test
  fun day1Part2() {
    day1Part2(input(1)) shouldBe 5
  }

  @Test
  fun day2() {
    day2(input(2)) shouldBe 150
  }

  @Test
  fun day2Part2() {
    day2Part2(input(2)) shouldBe 900
  }

  @Test
  fun day3() {
    day3(input(3)) shouldBe 198
  }

  @Test
  fun day3Part2() {
    day3Part2(input(3)) shouldBe 230
  }

  @Test
  fun day4() {
    day4(input(4)) shouldBe 4512
  }

  @Test
  fun day4Part2() {
    day4Part2(input(4)) shouldBe 1924
  }
}

private fun input(day: Int): String {
  return ClassLoader
    .getSystemResourceAsStream("day$day.txt")!!
    .bufferedReader()
    .readText()
}

@Suppress("unused")
private fun currentTaskInput(): String {
  return ClassLoader
    .getSystemResourceAsStream("task.txt")!!
    .bufferedReader()
    .readText()
}
