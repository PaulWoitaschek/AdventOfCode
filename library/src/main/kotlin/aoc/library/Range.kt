package aoc.library

fun IntRange.intersects(other: IntRange): Boolean {
  return last >= other.first && first <= other.last
}
