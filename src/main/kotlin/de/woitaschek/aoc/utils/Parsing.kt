package de.woitaschek.aoc.utils

fun String.lineSeparatedIntList(): List<Int> = lines().mapNotNull(String::toIntOrNull)
fun String.commaSeparatedIntList(): List<Int> = lines().first().split(",").map { it.toInt() }
