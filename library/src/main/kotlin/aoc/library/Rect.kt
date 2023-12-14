package aoc.library

data class Rect(
  val left: Int,
  val top: Int,
  val right: Int,
  val bottom: Int,
) {

  init {
    require(right >= left)
    require(top <= bottom)
  }

  operator fun contains(point: Point): Boolean {
    return point.x in left..right && point.y in top..bottom
  }

  fun height(): Int = bottom - top
}
