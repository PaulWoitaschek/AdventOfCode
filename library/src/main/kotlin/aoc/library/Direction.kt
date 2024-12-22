package aoc.library

enum class Direction(var char: Char, val arrow: Char) {
  Left('L', '<'),
  Up('U', '^'),
  Right('R', '>'),
  Down('D', 'v'),
  ;

  fun clockwise(): Direction = entries[(ordinal + 1) % entries.size]

  fun counterClockwise(): Direction = entries[(ordinal + entries.size - 1) % entries.size]

  fun opposite(): Direction = when (this) {
    Left -> Right
    Right -> Left
    Up -> Down
    Down -> Up
  }

  companion object {
    private val byChar = entries.associateBy { it.char }
    private val byArrow = entries.associateBy { it.arrow }
    fun parse(input: Char): Direction = byChar[input] ?: throw IllegalArgumentException("Invalid char=$input")

    fun fromArrowOrNull(arrow: Char): Direction? = byArrow[arrow]
  }
}
