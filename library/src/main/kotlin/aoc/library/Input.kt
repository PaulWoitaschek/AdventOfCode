package aoc.library

import okhttp3.OkHttpClient
import okhttp3.Request
import okio.buffer
import okio.sink
import java.io.File

fun <Part1, Part2> Puzzle<Part1, Part2>.solvePart1(): Part1 = solvePart1(input())

fun <Part1, Part2> Puzzle<Part1, Part2>.solvePart1WithTestInput(): Part1 = solvePart1(testInput())

fun <Part1, Part2> Puzzle<Part1, Part2>.solvePart2(): Part2 = solvePart2(input())

fun <Part1, Part2> Puzzle<Part1, Part2>.solvePart2WithTestInput(): Part2 = solvePart2(testInput())

fun Puzzle<*, *>.input(): String = aocInput(year = year, day = day)

private fun aocInput(
  year: Int,
  day: Int,
): String {
  val file = File("src/main/resources/$year/$day.txt").apply {
    parentFile.mkdirs()
  }
  if (!file.exists() || file.length() == 0L) {
    val sessionCookie = System.getenv("AOC_SESSION")
    check(!sessionCookie.isNullOrEmpty()) {
      "AOC_SESSION environment variable must be set to your session cookie"
    }
    val client = OkHttpClient()
    val response = client.newCall(
      Request.Builder()
        .url("https://adventofcode.com/$year/day/$day/input")
        .addHeader(
          "Cookie",
          "session=$sessionCookie",
        )
        .build(),
    ).execute()
    check(response.isSuccessful) {
      "Failed to download input for $year day $day: ${response.code}"
    }
    response.body!!.use {
      it.source().use { source ->
        file.sink().buffer().use { output ->
          output.writeAll(source)
        }
      }
    }
  }
  return file.readText().removeSuffix("\n")
}

private fun Puzzle<*, *>.testInput(): String = aocTestInput(year = year, day = day)

private fun aocTestInput(
  year: Int,
  day: Int,
): String {
  val file = File("src/main/resources/$year/$day-test.txt")
  return file.readText().removeSuffix("\n")
}
