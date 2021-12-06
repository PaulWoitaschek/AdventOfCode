@file:Suppress("ConvertCallChainIntoSequence")

object Day6 : Puzzle {

  override val day = 6

  override fun solvePart1(input: String): Int {
    return generateSequence(Ocean.parse(input)) { it.afterOneDay() }
      .take(81).last().totalFishes
  }

  override fun solvePart2(input: String): Int {
    return 42
  }
}

private data class Ocean(private val breedTimes: List<Int>) {

  val totalFishes: Int = breedTimes.size

  fun afterOneDay(): Ocean {
    val agedFishes = breedTimes.map { if (it == 0) 6 else it - 1 }
    val bornFishes = List(breedTimes.count { it == 0 }) { 8 }
    return Ocean(agedFishes + bornFishes)
  }

  companion object {
    fun parse(input: String): Ocean {
      val fishes = input.lines().single().split(",").map(String::toInt)
      return Ocean(fishes)
    }
  }
}