package de.woitaschek.aoc.year2015

import de.woitaschek.aoc.utils.Puzzle
import java.security.MessageDigest

object Day4 : Puzzle<Int, Int>(2015, 4) {

  override fun solvePart1(input: String): Int = lowestMatching(input) { hash ->
    hash[0] == 0.toByte() && hash[1] == 0.toByte() && hash[2] in 0..15
  }

  override fun solvePart2(input: String): Int = lowestMatching(input) { hash ->
    hash[0] == 0.toByte() && hash[1] == 0.toByte() && hash[2] == 0.toByte()
  }

  private inline fun lowestMatching(
    input: String,
    match: (ByteArray) -> Boolean,
  ): Int {
    val md5 = MessageDigest.getInstance("MD5")!!
    var value = 0
    while (true) {
      val candidate = "${input}$value"
      val hash = md5.digest(candidate.toByteArray())
      if (match(hash)) {
        return value
      }
      value++
    }
  }
}
