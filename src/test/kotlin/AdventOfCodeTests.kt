import io.kotest.matchers.shouldBe
import org.junit.Test

class AdventOfCodeTests {

  @Test
  fun day1() {
    Day1.test(part1 = 7, part2 = 5)
  }

  @Test
  fun day2() {
    Day2.test(part1 = 150, part2 = 900)
  }

  @Test
  fun day3() {
    Day3.test(part1 = 198, part2 = 230)
  }

  @Test
  fun day4() {
    Day4.test(part1 = 4512, part2 = 1924)
  }

  @Test
  fun day5() {
    Day5.test(part1 = 5, part2 = 12)
  }

  @Test
  fun day6() {
    Day6.solvePart1(input(Day6.day)) shouldBe 5934
    //Day6.test(part1 = 5934, part2 = 42)
  }

  private fun Puzzle.test(part1: Int, part2: Int) {
    val input = input(day)
    solvePart1(input) shouldBe part1
    solvePart2(input) shouldBe part2
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
