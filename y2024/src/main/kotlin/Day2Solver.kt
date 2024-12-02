package com.github.micheljung.adventofcode.y2024

import com.github.micheljung.adventofcode.common.Solver
import kotlin.math.abs

object Day2Solver : Solver {

  override fun solve(sequence: Sequence<String>): String {
    val list = sequence.toList()
    val part1 = list
      .map { it.split(" ").map(String::toInt) }
      .associateWith { isSafe(it) }
      .values
      .count { it }
      .toString()

    val part2 = list
      .map { it.split(" ").map(String::toInt) }
      .count { isSafeWithDampener(it) }
      .toString()

    return "$part1, $part2"
  }

  private fun isSafeWithDampener(ints: List<Int>): Boolean {
    var index = 0
    return ints.any {
      val dampened = mutableListOf(*ints.toTypedArray()).apply {
        removeAt(index++)
      }
      isSafe(dampened)
    }
  }

  private fun isSafe(ints: List<Int>): Boolean {
    var isLineIncreasing: Boolean? = null
    for ((current, previous) in ints.windowed(2)) {
      val isWithinDistance = abs(current - previous) in 1..3
      if (!isWithinDistance) return false

      val isCurrentIncreasing = current > previous
      if (isLineIncreasing == null) isLineIncreasing = isCurrentIncreasing
      when {
        isLineIncreasing && !isCurrentIncreasing -> return false
        !isLineIncreasing && isCurrentIncreasing -> return false
      }
    }

    return true
  }
}
