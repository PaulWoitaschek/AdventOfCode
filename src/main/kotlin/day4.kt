@file:Suppress("ConvertCallChainIntoSequence")

fun day4(input: String): Int {
  val game = Game.parse(input)

  val allDraws = game.allDraws
  val boards = game.boards

  (allDraws.indices).forEach { round ->
    val draws = allDraws.take(round)
    boards.forEach { board ->
      if (board.hasWon(draws)) {
        return board.score(draws)
      }
    }
  }
  error("No winners!")
}

fun day4Part2(input: String): Int {
  val game = Game.parse(input)

  val allDraws = game.allDraws
  var boards = game.boards

  var lastWinner: Board? = null
  var lastDraw: List<Int> = allDraws
  (allDraws.indices).forEach { round ->
    val draws = allDraws.take(round)
    val winnersOfRound = boards.filter { it.hasWon(draws) }
    if (winnersOfRound.isNotEmpty()) {
      boards = boards - winnersOfRound
      lastWinner = winnersOfRound.last()
      lastDraw = draws
    }
  }
  return checkNotNull(lastWinner) { "No winners!" }
    .score(lastDraw)
}

data class Game(
  val allDraws: List<Int>,
  val boards: List<Board>,
) {

  companion object {
    fun parse(input: String): Game {
      val lines = input.lines()
      val draws = lines.first().split(",").map { it.toInt() }

      val boards = lines.drop(1)
        .filter { it.isNotEmpty() }
        .map { line ->
          line.split("\\s+".toRegex())
            .filter { it.isNotBlank() }
            .map { it.toInt() }
        }
        .chunked(5)
        .map { Board(it) }
      return Game(draws, boards)
    }
  }
}

data class Board(
  val numbers: List<List<Int>>,
) {

  private val rows: List<List<Int>> = numbers
  private val columns: List<List<Int>>

  init {
    columns = mutableListOf()
    (0 until SIZE).forEach { i ->
      columns.add(numbers.map { it[i] })
    }
  }

  init {
    require(numbers.size == SIZE)
    numbers.forEach {
      require(it.size == SIZE)
    }
  }

  fun hasWon(draws: List<Int>): Boolean {
    return rows.any { it.hasWon(draws) } || columns.any { it.hasWon(draws) }
  }

  fun score(draws: List<Int>): Int {
    return numbers.flatten()
      .filter { it !in draws }
      .sum() * draws.last()
  }

  private fun List<Int>.hasWon(draws: List<Int>): Boolean {
    return all { it in draws }
  }

  companion object {

    const val SIZE = 5
  }
}