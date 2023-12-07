package aoc.year2023

import aoc.library.Puzzle

object Day7 : Puzzle<Int, Int>(year = 2023, day = 7) {

  override fun solvePart1(input: String): Int = solve(input = input, accountForJokers = false)
  override fun solvePart2(input: String): Int = solve(input = input, accountForJokers = true)

  private fun solve(
    input: String,
    accountForJokers: Boolean,
  ): Int {
    return input.lines()
      .map(Hand::parse)
      .sortedWith(HandComparator(accountForJokers))
      .mapIndexed { index, hand ->
        val rank = index + 1
        rank * hand.bid
      }
      .sum()
  }

  private data class Hand(val cards: List<Char>, val bid: Int) {
    companion object {
      fun parse(input: String): Hand {
        val (cards, bid) = input.split(" ")
        return Hand(cards = cards.toList(), bid = bid.toInt())
      }
    }
  }

  private class HandComparator(private val accountForJokers: Boolean) : Comparator<Hand> {

    private val cardRanks = if (accountForJokers) {
      "J23456789TQKA"
    } else {
      "23456789TJQKA"
    }.withIndex().associate { it.value to it.index }

    override fun compare(
      o1: Hand,
      o2: Hand,
    ): Int {
      val byType = o2.type().compareTo(o1.type())
      if (byType != 0) return byType
      return o1.cards.zip(o2.cards) { left, right ->
        cardRanks.getValue(left)
          .compareTo(cardRanks.getValue(right))
      }.firstOrNull { it != 0 } ?: 0
    }

    private fun Hand.type(): Type {
      val grouping = cards.groupingBy { it }.eachCount()
      val groupingValuesWithoutJoker = grouping.filter {
        !accountForJokers || it.key != 'J'
      }.values
      val jokers = if (!accountForJokers) 0 else grouping['J'] ?: 0
      val max = groupingValuesWithoutJoker.maxOrNull() ?: return Type.FiveOfAKind
      val maxWithJokers = max + jokers
      if (maxWithJokers >= 5) return Type.FiveOfAKind
      if (maxWithJokers >= 4) return Type.FourOfAKind
      if (jokers > 0) {
        if (groupingValuesWithoutJoker.count { it >= 2 } >= 2) {
          return Type.FullHouse
        }
      }
      if (3 in groupingValuesWithoutJoker && 2 in groupingValuesWithoutJoker) {
        return Type.FullHouse
      }
      if (maxWithJokers >= 3) return Type.ThreeOfAKind
      if (groupingValuesWithoutJoker.count { it == 2 } == 2) return Type.TwoPair
      if (maxWithJokers >= 2) return Type.OnePair
      return Type.HighCard
    }
  }

  enum class Type {
    FiveOfAKind,
    FourOfAKind,
    FullHouse,
    ThreeOfAKind,
    TwoPair,
    OnePair,
    HighCard,
  }
}
