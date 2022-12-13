package de.woitaschek.aoc.year2022

import de.woitaschek.aoc.utils.Puzzle

object Day13 : Puzzle(2022, 13) {

  override fun solvePart1(input: String): Any {
    return input.split("\n\n").mapIndexedNotNull { group, it ->
      val (left, right) = it.lines().take(2).map(Package::parse)
      (group + 1).takeIf { order(left.value, right.value)!! <= 0 }
    }.reduce(Int::plus)
  }

  override fun solvePart2(input: String): Any {
    val distressPackages = listOf("[[2]]", "[[6]]").map(Package::parse)
    val inputPackages = input.lines().filter(String::isNotBlank).map(Package::parse)
    val sortedPackages = (distressPackages + inputPackages).sorted()
    return distressPackages.map { sortedPackages.indexOf(it) + 1 }.reduce(Int::times)
  }

  data class Package(val value: Element.Multiple) : Comparable<Package> {

    override fun compareTo(other: Package): Int = order(this.value, other.value)!!

    sealed interface Element {

      data class Value(val value: Int) : Element

      data class Multiple(val elements: List<Element>) : Element {
        companion object {
          fun parse(input: String): Multiple {
            if (input == "[]") return Multiple(emptyList())
            val splitAtIndices = mutableListOf<Int>()
            var level = 0
            var splitAt = 1
            val elements = mutableListOf<Element>()
            input.forEachIndexed { index, c ->
              level += when (c) {
                '[' -> 1
                ']' -> -1
                else -> 0
              }
              if (level == 1 && c == ',') {
                elements.add(Element.parse(input.substring(splitAt, index)))
                splitAt = index + 1
                splitAtIndices += index
              }
            }
            elements.add(Element.parse(input.substring(splitAt, input.length - 1)))
            return Multiple(elements)
          }
        }
      }

      companion object {
        fun parse(input: String): Element = if (input.startsWith('[')) {
          Multiple.parse(input)
        } else Value(input.toInt())
      }
    }

    companion object {
      fun parse(input: String): Package = Package(Element.Multiple.parse(input))
    }
  }
}

private fun order(left: Day13.Package.Element, right: Day13.Package.Element): Int? {
  return if (left is Day13.Package.Element.Value && right is Day13.Package.Element.Value) {
    (left.value - right.value).takeUnless { it == 0 }
  } else if (left is Day13.Package.Element.Multiple && right is Day13.Package.Element.Multiple) {
    repeat(maxOf(left.elements.size, right.elements.size)) { index ->
      val leftValue = left.elements.getOrNull(index)
      val rightValue = right.elements.getOrNull(index)
      if (leftValue == null) {
        return Int.MIN_VALUE
      } else if (rightValue == null) {
        return Int.MAX_VALUE
      } else {
        val childInOrder = order(leftValue, rightValue)
        if (childInOrder != null) {
          return childInOrder
        }
      }
    }
    null
  } else if (left is Day13.Package.Element.Multiple && right is Day13.Package.Element.Value) {
    order(left, Day13.Package.Element.Multiple(listOf(right)))
  } else if (left is Day13.Package.Element.Value && right is Day13.Package.Element.Multiple) {
    order(Day13.Package.Element.Multiple(listOf(left)), right)
  } else {
    error("This can not be!")
  }
}
