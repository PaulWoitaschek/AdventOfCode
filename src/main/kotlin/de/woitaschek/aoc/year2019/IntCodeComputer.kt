package de.woitaschek.aoc.year2019

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.Channel.Factory.UNLIMITED
import kotlinx.coroutines.channels.ReceiveChannel
import kotlin.math.pow

class IntCodeComputer(
  instructions: List<Int>,
  val inputs: ReceiveChannel<Int>,
  val outputs: Channel<Int> = Channel(UNLIMITED),
) {

  private val instructions = instructions.toMutableList()

  constructor(
    instructions: List<Int>,
    inputs: List<Int>,
  ) : this(
    instructions = instructions,
    inputs = Channel<Int>(UNLIMITED)
      .also { channel ->
        inputs.forEach {
          check(channel.trySend(it).isSuccess)
        }
      },
  )

  private var pointer = 0
  private var finished = false

  private val output = StringBuilder()

  var latestOutput: Int = 0
    private set
  val fullOutput: Int
    get() = output.toString().toInt()
  val firstInstruction: Int
    get() = instructions.first()

  suspend fun run() {
    while (!finished) {
      runInstruction()
    }
  }

  private fun read(index: Int): Int {
    val value = instructions[pointer + index + 1]
    val instructionValue = instructions[pointer]
    return when (val v = instructionValue / 10.toFloat().pow(index + 2).toInt() % 10) {
      0 -> instructions[value]
      1 -> value
      else -> error("Invalid mode=$v")
    }
  }

  private fun write(
    index: Int,
    value: Int,
  ) {
    instructions[instructions[pointer + index + 1]] = value
  }

  private suspend fun runInstruction() {
    when (val opCode = instructions[pointer] % 100) {
      1 -> {
        write(2, read(0) + read(1))
        pointer += 4
      }
      2 -> {
        write(2, read(0) * read(1))
        pointer += 4
      }
      3 -> {
        val received = inputs.receive()
        write(0, received)
        pointer += 2
      }
      4 -> {
        val o = read(0)
        output.append(o)
        latestOutput = o
        outputs.send(o)
        pointer += 2
      }
      5 -> {
        if (read(0) != 0) {
          pointer = read(1)
        } else {
          pointer += 3
        }
      }
      6 -> {
        if (read(0) == 0) {
          pointer = read(1)
        } else {
          pointer += 3
        }
      }
      7 -> {
        val value = if (read(0) < read(1)) 1 else 0
        write(2, value)
        pointer += 4
      }
      8 -> {
        val value = if (read(0) == read(1)) 1 else 0
        write(2, value)
        pointer += 4
      }
      99 -> {
        finished = true
      }
      else -> error("Invalid opCode=$opCode")
    }
  }
}
