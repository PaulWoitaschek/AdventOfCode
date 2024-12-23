package aoc.year2024

import aoc.library.solvePart1
import aoc.library.solvePart2
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.ints.shouldBeExactly
import org.junit.jupiter.api.Test

class Day23Test {

  private val testData = """
      kh-tc
      qp-kh
      de-cg
      ka-co
      yn-aq
      qp-ub
      cg-tb
      vc-aq
      tb-ka
      wh-tc
      yn-cg
      kh-ub
      ta-co
      de-co
      tc-td
      tb-wq
      wh-td
      ta-ka
      td-qp
      aq-cg
      wq-ub
      ub-vc
      de-ta
      wq-aq
      wq-vc
      wh-yn
      ka-de
      kh-ta
      co-tc
      wh-qp
      tb-vc
      td-yn
  """.trimIndent()

  @Test
  fun part1TestInput() {
    Day23.solvePart1(testData) shouldBeExactly 7
  }

  @Test
  fun part1() {
    Day23.solvePart1() shouldBeExactly 1108
  }

  @Test
  fun part2TestInput() {
    Day23.solvePart2(testData) shouldContainExactly "co,de,ka,ta".split(",")
  }

  @Test
  fun part2() {
    Day23.solvePart2()
      .shouldContainExactly("ab,cp,ep,fj,fl,ij,in,ng,pl,qr,rx,va,vf".split(","))
  }
}
