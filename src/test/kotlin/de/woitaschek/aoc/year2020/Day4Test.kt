package de.woitaschek.aoc.year2020

import de.woitaschek.aoc.test
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day4Test {

  @Test
  fun part1() {
    Day4.test(
      part1Test = 2,
      part1 = 190,
    )
  }

  @Test
  fun part2() {
    Day4.test(
      part2Test = 2,
      part2 = 121,
    )
  }

  @Test
  fun passportCorrect() {
    with(Day4) {
      parsePassport(
        """
      pid:087499704 hgt:74in ecl:grn iyr:2012 eyr:2030 byr:1980
      hcl:#623a2f
        """.trimIndent(),
      ).allFieldsCorrect() shouldBe true

      parsePassport(
        """
      eyr:2029 ecl:blu cid:129 byr:1989
      iyr:2014 pid:896056539 hcl:#a97842 hgt:165cm
        """.trimIndent(),
      ).allFieldsCorrect() shouldBe true

      parsePassport(
        """
      hcl:#888785
      hgt:164cm byr:2001 iyr:2015 cid:88
      pid:545766238 ecl:hzl
      eyr:2022
        """.trimIndent(),
      ).allFieldsCorrect() shouldBe true

      parsePassport(
        """
      iyr:2010 hgt:158cm hcl:#b6652a ecl:blu byr:1944 eyr:2021 pid:093154719
        """.trimIndent(),
      ).allFieldsCorrect() shouldBe true

      parsePassport(
        """
      eyr:1972 cid:100
      hcl:#18171d ecl:amb hgt:170 pid:186cm iyr:2018 byr:1926
        """.trimIndent(),
      ).allFieldsCorrect() shouldBe false

      parsePassport(
        """
      iyr:2019
      hcl:#602927 eyr:1967 hgt:170cm
      ecl:grn pid:012533040 byr:1946
        """.trimIndent(),
      ).allFieldsCorrect() shouldBe false

      parsePassport(
        """
      hcl:dab227 iyr:2012
      ecl:brn hgt:182cm pid:021572410 eyr:2020 byr:1992 cid:277
        """.trimIndent(),
      ).allFieldsCorrect() shouldBe false

      parsePassport(
        """
      hgt:59cm ecl:zzz
      eyr:2038 hcl:74454a iyr:2023
      pid:3556412378 byr:2007
        """.trimIndent(),
      ).allFieldsCorrect() shouldBe false
    }
  }
}
