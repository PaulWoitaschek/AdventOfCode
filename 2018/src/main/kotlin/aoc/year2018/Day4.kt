package aoc.year2018

import aoc.library.Puzzle

object Day4 : Puzzle<Int, Int>(year = 2018, day = 4) {

  override fun solvePart1(input: String): Int {
    val sleepyGuard = guards(input).maxBy { it.sleepTimes.size }
    return sleepyGuard.id * sleepyGuard.mostSleepingMinute().minute
  }

  override fun solvePart2(input: String): Int {
    return guards(input).maxBy { it.mostSleepingMinute().times }
      .let { it.id * it.mostSleepingMinute().minute }
  }

  private fun guards(input: String): List<Guard> {
    val wholeRegex = ".*?:(\\d+)] (.*)$".toRegex()
    val guardRegex = """^Guard #(\d+)""".toRegex()
    val guards = mutableMapOf<Int, Guard>()
    var currentGuard = 0
    var fellAsleepAt = 0
    input.lines().sorted().forEach { line ->
      val (minuteValue, rest) = wholeRegex.find(line)!!.destructured
      val minute = minuteValue.toInt()
      when (rest) {
        "falls asleep" -> {
          fellAsleepAt = minute
        }
        "wakes up" -> {
          guards.getOrPut(currentGuard) { Guard(currentGuard, mutableListOf()) }
            .sleepTimes.addAll(fellAsleepAt..<minute)
        }
        else -> {
          currentGuard = guardRegex.find(rest)!!.groupValues[1].toInt()
        }
      }
    }
    return guards.values.toList()
  }
}

private data class Guard(val id: Int, val sleepTimes: MutableList<Int>) {
  fun mostSleepingMinute(): SleepingMinute {
    if (sleepTimes.isEmpty()) {
      return SleepingMinute(0, 0)
    }
    return sleepTimes.groupingBy { it }.eachCount()
      .maxBy { it.value }
      .let { SleepingMinute(minute = it.key, times = it.value) }
  }
}

private data class SleepingMinute(
  val minute: Int,
  val times: Int,
)
