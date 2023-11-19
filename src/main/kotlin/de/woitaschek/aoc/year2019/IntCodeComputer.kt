package de.woitaschek.aoc.year2019

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.Channel.Factory.UNLIMITED
import kotlinx.coroutines.channels.ReceiveChannel
import kotlin.math.pow

class IntCodeComputer(
  instructions: List<Long>,
  val inputs: ReceiveChannel<Long>,
  val outputs: Channel<Long> = Channel(UNLIMITED),
) {

  private val instructions: MutableMap<Long, Long> = instructions.withIndex().associate {
    it.index.toLong() to it.value
  }.toMutableMap()

  constructor(
    instructions: List<Long>,
    inputs: List<Long>,
  ) : this(
    instructions = instructions,
    inputs = Channel<Long>(UNLIMITED)
      .also { channel ->
        inputs.forEach {
          check(channel.trySend(it).isSuccess)
        }
      },
  )

  private var pointer = 0L
  private var finished = false

  private val output = StringBuilder()

  var latestOutput: Long = 0
    private set
  val fullOutput: Long
    get() = output.toString().toLong()
  val firstInstruction: Long
    get() = instructions.getValue(0)

  suspend fun run() {
    while (!finished) {
      runInstruction()
    }
  }

  private fun read(index: Long): Long {
    val value = instructions.getValue(pointer + index + 1)
    val instructionValue = instructions.getValue(pointer)
    return when (val v = (instructionValue / 10.toFloat().pow(index.toFloat() + 2).toLong() % 10).toInt()) {
      0 -> instructions.getValue(value)
      1 -> value
      else -> error("Invalid mode=$v")
    }
  }

  private fun write(
    index: Long,
    value: Long,
  ) {
    instructions[instructions.getValue(pointer + index + 1)] = value
  }

  private suspend fun runInstruction() {
    when (val opCode = (instructions.getValue(pointer) % 100).toInt()) {
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
        if (read(0) != 0L) {
          pointer = read(1)
        } else {
          pointer += 3
        }
      }
      6 -> {
        if (read(0) == 0L) {
          pointer = read(1)
        } else {
          pointer += 3
        }
      }
      7 -> {
        val value: Long = if (read(0) < read(1)) 1 else 0
        write(2, value)
        pointer += 4
      }
      8 -> {
        val value: Long = if (read(0) == read(1)) 1 else 0
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
