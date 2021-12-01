import io.kotest.matchers.shouldBe
import org.junit.Test

class AdventOfCodeTests {

  @Test
  fun day1() {
    day1(input(1)) shouldBe 7
  }

  @Test
  fun day1Part2() {
    day1PartTwo(input(1)) shouldBe 5
  }
}

private fun input(
  @Suppress("SameParameterValue") day: Int
): Sequence<String> {
  return ClassLoader
    .getSystemResourceAsStream("day$day.txt")
    .bufferedReader()
    .lineSequence()
}

@Suppress("unused")
private fun currentTaskInput(): Sequence<String> {
  return ClassLoader
    .getSystemResourceAsStream("task.txt")
    .bufferedReader()
    .lineSequence()
}
