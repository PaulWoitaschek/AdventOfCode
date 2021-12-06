object Day2 : Puzzle {

  override val day = 2

  override fun solvePart1(input: String): Long {
    return process(input, accountAim = false)
  }

  override fun solvePart2(input: String): Long {
    return process(input, accountAim = true)
  }
}

private fun process(input: String, accountAim: Boolean): Long {
  val position = input.lineSequence()
    .map { Instruction.parse(it) }
    .fold(Position.INITIAL) { position, instruction ->
      position.plusInstruction(instruction, accountAim)
    }
  return (position.depth * position.horizontal).toLong()
}

private enum class Direction {
  Forward, Up, Down
}

private data class Position(
  val horizontal: Int,
  val depth: Int,
  val aim: Int,
) {

  fun plusInstruction(instruction: Instruction, accountAim: Boolean): Position {
    val steps = instruction.steps
    return if (accountAim) {
      when (instruction.direction) {
        Direction.Forward -> copy(
          horizontal = horizontal + steps,
          depth = depth + aim * steps
        )
        Direction.Up -> copy(aim = aim - steps)
        Direction.Down -> copy(aim = aim + steps)
      }
    } else {
      when (instruction.direction) {
        Direction.Forward -> copy(horizontal = horizontal + steps)
        Direction.Up -> copy(depth = depth - steps)
        Direction.Down -> copy(depth = depth + steps)
      }
    }
  }

  companion object {
    val INITIAL = Position(0, 0, 0)
  }
}

private data class Instruction(
  val direction: Direction,
  val steps: Int
) {
  companion object {
    fun parse(input: String): Instruction {
      val (directionString, stepString) = input.split(" ")
      val direction = when (directionString) {
        "forward" -> Direction.Forward
        "down" -> Direction.Down
        "up" -> Direction.Up
        else -> error("Invalid direction=$directionString")
      }
      val steps = stepString.toInt()
      return Instruction(steps = steps, direction = direction)
    }
  }
}