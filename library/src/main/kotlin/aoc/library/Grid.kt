package aoc.library

typealias Grid<Tile> = Map<Point, Tile>

fun <Tile> grid(
  input: String,
  tile: (Char) -> Tile,
): Grid<Tile> = input.lines().flatMapIndexed { y, line ->
  line.mapIndexed { x, char ->
    Point(x, y) to tile(char)
  }
}.toMap()

fun grid(input: String): Grid<Char> = input.lines().flatMapIndexed { y, line ->
  line.mapIndexed { x, char ->
    Point(x, y) to char
  }
}.toMap()
