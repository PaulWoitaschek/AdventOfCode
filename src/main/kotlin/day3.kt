typealias BitRow = List<Boolean>

fun day3(input: String): Int {
  val bitRows = parseInput(input)
  val gamma: List<Boolean> = (0 until bitRows.first().size)
    .map { index ->
      bitRows.count { it[index] } >= bitRows.size / 2
    }
  val epsilon = gamma.flipped()
  return gamma.toInt() * epsilon.toInt()
}

fun day3Part2(input: String): Int {
  val bitRows = parseInput(input)

  val oxygen = extractForBitCriteria(bitRows, bitCriteria = true)
  val co2Scrubber = extractForBitCriteria(bitRows, bitCriteria = false)

  return oxygen * co2Scrubber
}

private fun parseInput(input: String): List<BitRow> {
  return input.lines()
    .map { line -> line.map { it == '1' } }
}

private fun extractForBitCriteria(lines: List<List<Boolean>>, bitCriteria: Boolean): Int {
  val bitsPerLine = lines.first().size

  var candidates = lines
  for (index in 0 until bitsPerLine) {
    val bitRow = candidates.map { it[index] }
    val trueCount = bitRow.count(selector = true)
    val falseCount = bitRow.count(selector = false)
    val toKeep = if (bitCriteria) {
      trueCount >= falseCount
    } else {
      trueCount < falseCount
    }
    candidates = candidates.filter {
      it[index] == toKeep
    }
    if (candidates.size == 1) {
      break
    }
  }

  return candidates.single().toInt()
}

private fun BitRow.count(selector: Boolean) = count { it == selector }

private fun List<Boolean>.toInt(): Int {
  return joinToString(separator = "") { if (it) "1" else "0" }.toInt(2)
}

private fun List<Boolean>.flipped(): List<Boolean> {
  return map { !it }
}
