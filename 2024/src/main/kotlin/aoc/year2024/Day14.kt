package aoc.year2024

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.singleWindowApplication
import aoc.library.Point
import aoc.library.Puzzle
import aoc.library.aocInput
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.String

object Day14 : Puzzle<Int, Int>(day = 14) {

  private const val DEFAULT_WIDTH = 101
  private const val DEFAULT_HEIGHT = 103

  override fun solvePart1(input: String): Int = solvePart1(input, DEFAULT_WIDTH, DEFAULT_HEIGHT)

  fun solvePart1(
    input: String,
    width: Int,
    height: Int,
  ): Int = generateSequence(parse(input)) { robots ->
    robots.map { robot -> robot.step(width, height) }
  }
    .elementAt(100)
    .groupBy {
      quadrant(it, width, height)
    }
    .mapValues { it.value.size }
    .filterKeys { it != null }.values
    .reduce(Int::times)

  private fun quadrant(
    robot: Robot,
    width: Int,
    height: Int,
  ): Int? {
    val (x, y) = robot.position
    val centerX = width / 2
    val centerY = height / 2
    return when {
      x < centerX && y < centerY -> 1
      x > centerX && y < centerY -> 2
      x < centerX && y > centerY -> 3
      x > centerX && y > centerY -> 4
      else -> null
    }
  }

  override fun solvePart2(input: String): Int = solvePart2(input, onStep = {})

  private fun solvePart2(
    input: String,
    onStep: (List<Robot>) -> Unit,
  ) = generateSequence(parse(input)) { robots ->
    robots.map { robot -> robot.step(DEFAULT_WIDTH, DEFAULT_HEIGHT) }
  }
    .onEach { onStep(it) }
    .indexOfFirst(::hasRobotCluster)

  private fun hasRobotCluster(robots: List<Robot>): Boolean {
    val positions = robots.map { it.position }.toSet()
    return positions.any {
      positions.containsAll(it.adjacent())
    }
  }

  private fun parse(input: String): List<Robot> = input.lines().map(Robot::parse)

  private data class Robot(val position: Point, val velocity: Point) {
    companion object {
      private val regex = """^p=(\d+),(\d+) v=(-?\d+),(-?\d+)$""".toRegex()
      fun parse(input: String): Robot {
        val (px, py, vx, vy) = regex.find(input)!!.destructured.toList().map(String::toInt)
        return Robot(position = Point(px, py), velocity = Point(vx, vy))
      }
    }

    fun step(
      width: Int,
      height: Int,
    ): Robot = copy(
      position = Point(
        x = (position.x + velocity.x + width) % width,
        y = (position.y + velocity.y + height) % height,
      ),
    )
  }

  @JvmStatic
  fun main(args: Array<String>) {
    val tileSize = 8.dp
    singleWindowApplication(
      title = "Advent of Code in Kotlin",
      state = WindowState(width = tileSize * DEFAULT_WIDTH, height = tileSize * DEFAULT_HEIGHT),
    ) {
      var state by remember { mutableStateOf<Set<Point>>(emptySet()) }
      LaunchedEffect(Unit) {
        val steps = mutableListOf<Set<Point>>()
        solvePart2(
          aocInput(2024, 14),
          onStep = {
            launch {
              steps += it.map { it.position }.toSet()
            }
          },
        )
        withContext(Dispatchers.Default) {}
        steps.forEach {
          delay(1)
          state = it
        }
      }
      Column {
        repeat(DEFAULT_HEIGHT) { y ->
          Row {
            repeat(DEFAULT_WIDTH) { x ->
              val color = if (Point(x, y) in state) {
                Color(0xFF228B22)
              } else {
                Color(0xFF001F3F)
              }
              Box(Modifier.size(tileSize).background(color))
            }
          }
        }
      }
    }
  }
}
