package de.woitaschek.aoc.utils

fun String.intList(): List<Int> = lines().mapNotNull(String::toIntOrNull)
