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
}

private fun input(
  @Suppress("SameParameterValue") day: Int
): Sequence<String> {
  return ClassLoader
    .getSystemResourceAsStream("day$day.txt")!!
    .bufferedReader()
    .lineSequence()
}

@Suppress("unused")
private fun currentTaskInput(): Sequence<String> {
  return ClassLoader
    .getSystemResourceAsStream("task.txt")!!
    .bufferedReader()
    .lineSequence()
}
