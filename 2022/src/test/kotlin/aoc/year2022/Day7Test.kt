package aoc.year2022

import aoc.library.solvePart1
import aoc.library.solvePart2
import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class Day7Test {

  @Test
  fun part1TestInput() {
    assertEquals(
      95437,
      Day7.solvePart1(
        """
$ cd /
$ ls
dir a
14848514 b.txt
8504156 c.dat
dir d
$ cd a
$ ls
dir e
29116 f
2557 g
62596 h.lst
$ cd e
$ ls
584 i
$ cd ..
$ cd ..
$ cd d
$ ls
4060174 j
8033020 d.log
5626152 d.ext
7214296 k
        """
          .trimIndent(),
      ),
    )
  }

  @Test
  fun part2TestInput() {
    assertEquals(
      24933642,
      Day7.solvePart2(
        """
$ cd /
$ ls
dir a
14848514 b.txt
8504156 c.dat
dir d
$ cd a
$ ls
dir e
29116 f
2557 g
62596 h.lst
$ cd e
$ ls
584 i
$ cd ..
$ cd ..
$ cd d
$ ls
4060174 j
8033020 d.log
5626152 d.ext
7214296 k
        """
          .trimIndent(),
      ),
    )
  }

  @Test
  fun part1() {
    assertEquals(1477771, Day7.solvePart1())
  }

  @Test
  fun part2() {
    assertEquals(3579501, Day7.solvePart2())
  }
}
