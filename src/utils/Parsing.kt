package utils

fun String.toLineSeparatedIntList(): List<Int> = lines().mapNotNull(String::toIntOrNull)
fun String.toCommaSeparatedIntList(): List<Int> = lines().first().split(",").map { it.toInt() }
fun String.toCommaSeparatedLongList(): List<Long> = lines().first().split(",").map { it.toLong() }
fun String.toLineSeparatedStringList(): List<String> = lines().filter(String::isNotEmpty)
fun String.toSingleLine(): String = lines().first()
fun String.toLineList(): List<String> = lines().filter(String::isNotEmpty)
