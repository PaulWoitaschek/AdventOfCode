package de.woitaschek.aoc.year2019

import de.woitaschek.aoc.utils.Puzzle
import de.woitaschek.aoc.utils.toCommaSeparatedIntList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

object Day7 : Puzzle<Int, Int>(2019, 7) {

  override fun solvePart1(input: String): Int {
    val values = input.toCommaSeparatedIntList()
    var max = 0
    settingsCombinations(0..4).forEach { settings ->
      var previousOutput = 0
      settings.forEach {
        previousOutput = calculate(values, listOf(it, previousOutput))
      }
      max = maxOf(max, previousOutput)
    }
    return max
  }

  private fun calculate(
    values: List<Int>,
    inputs: List<Int>,
  ): Int {
    val computer = IntCodeComputer(values.toMutableList(), inputs.toMutableList())
    runBlocking { computer.run() }
    return computer.fullOutput
  }

  override fun solvePart2(input: String): Int = runBlocking(Dispatchers.Default) {
    val values = input.toCommaSeparatedIntList()
    var max = 0
    settingsCombinations(5..9).forEach { settings ->
      fun Channel<Int>.withInitialValue(vararg initial: Int): ReceiveChannel<Int> {
        @OptIn(ExperimentalCoroutinesApi::class)
        return produce {
          initial.forEach {
            send(it)
          }
          consumeEach {
            send(it)
          }
        }
      }

      val eOutput = Channel<Int>(Channel.RENDEZVOUS)
      val a = IntCodeComputer(values, eOutput.withInitialValue(settings[0], 0))
      val b = IntCodeComputer(values, a.outputs.withInitialValue(settings[1]))
      val c = IntCodeComputer(values, b.outputs.withInitialValue(settings[2]))
      val d = IntCodeComputer(values, c.outputs.withInitialValue(settings[3]))
      val e = IntCodeComputer(values, d.outputs.withInitialValue(settings[4]), eOutput)
      coroutineScope {
        launch { a.run() }
        launch { b.run() }
        launch { c.run() }
        launch { d.run() }
        launch { e.run() }
      }
      listOf(a, b, c, d, e).forEach {
        it.inputs.cancel()
        it.outputs.cancel()
      }
      val value = e.latestOutput
      max = maxOf(max, value)
    }
    max
  }

  private fun settingsCombinations(range: IntRange): List<List<Int>> {
    val options = range.toList()
    check(options.size == 5)
    val combinations = mutableListOf<List<Int>>()
    repeat(5) { a ->
      repeat(5) { b ->
        repeat(5) { c ->
          repeat(5) { d ->
            repeat(5) { e ->
              val settings = setOf(options[a], options[b], options[c], options[d], options[e])
              if (settings.size == 5) {
                combinations.add(settings.toList())
              }
            }
          }
        }
      }
    }
    return combinations
  }
}
