package aoc.year2023

import aoc.library.solvePart1
import aoc.library.solvePart2
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day19Test {

  private val testInput = """
      px{a<2006:qkq,m>2090:A,rfg}
      pv{a>1716:R,A}
      lnx{m>1548:A,A}
      rfg{s<537:gd,x>2440:R,A}
      qs{s>3448:A,lnx}
      qkq{x<1416:A,crn}
      crn{x>2662:A,R}
      in{s<1351:px,qqz}
      qqz{s>2770:qs,m<1801:hdj,R}
      gd{a>3333:R,R}
      hdj{m>838:A,pv}

      {x=787,m=2655,a=1222,s=2876}
      {x=1679,m=44,a=2067,s=496}
      {x=2036,m=264,a=79,s=2244}
      {x=2461,m=1339,a=466,s=291}
      {x=2127,m=1623,a=2188,s=1013}
  """.trimIndent()

  @Test
  fun part1TestInput() {
    assertEquals(19114, Day19.solvePart1(testInput))
  }

  @Test
  fun part1() {
    assertEquals(432434, Day19.solvePart1())
  }

  @Test
  fun part2TestInput() {
    assertEquals(167409079868000, Day19.solvePart2(testInput))
  }

  @Test
  fun part2() {
    assertEquals(132557544578569, Day19.solvePart2())
  }
}
