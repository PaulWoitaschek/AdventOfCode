package de.woitaschek.aoc

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import de.woitaschek.aoc.utils.Point
import de.woitaschek.aoc.year2022.Day14
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlin.time.Duration.Companion.milliseconds

private data class CaveSnapshot(
  val sands: Set<Point>,
  val rocks: Set<Point>,
)

fun main() {
  val caveFlow = flow {
    val cave = Day14.Cave.parse(aocInput(2022, 14))
    suspend fun emitCave() {
      emit(
        CaveSnapshot(
          sands = cave.sands.toSet(),
          rocks = cave.rocks,
        ),
      )
    }
    emitCave()
    val rockBottom: Int = cave.rocks.maxOf { it.y }
    while (true) {
      delay(1.milliseconds)
      cave.advanceTime()
      emitCave()
      if (cave.sands.any { it.y >= rockBottom }) {
        return@flow
      }
    }
  }
  application {
    Window(
      onCloseRequest = ::exitApplication,
      title = "Compose for Desktop",
      state = rememberWindowState(width = 800.dp, height = 800.dp),
    ) {
      MaterialTheme {
        var playing by remember { mutableStateOf(false) }
        if (playing) {
          val cave = remember { caveFlow }.collectAsState(null).value ?: return@MaterialTheme

          val occupiedSpaces = cave.sands + cave.rocks + Day14.Cave.SandOrigin
          val xRange = (occupiedSpaces.minOf { it.x }..occupiedSpaces.maxOf { it.x })
          val yRange = occupiedSpaces.minOf { it.y }..occupiedSpaces.maxOf { it.y }

          Column {
            yRange.take(29).forEach { y ->
              Row {
                xRange.forEach { x ->
                  val modifier = Modifier.size(size = 16.dp)
                  when (Point(x, y)) {
                    in cave.sands -> Text("\uD83C\uDFDC️", modifier)
                    Day14.Cave.SandOrigin -> Text("\uD83C\uDFC1", modifier)
                    in cave.rocks -> Text("\uD83E\uDEA8", modifier)
                    else -> {
                      Spacer(modifier)
                    }
                  }
                }
              }
            }
          }
        } else {
          Button(
            modifier = Modifier.padding(horizontal = 24.dp, vertical = 16.dp),
            onClick = { playing = true },
            content = { Text("Play!") },
          )
        }
      }
    }
  }
}
