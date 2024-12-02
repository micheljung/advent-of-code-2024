package com.github.micheljung.adventofcode.y2024

import com.github.micheljung.adventofcode.common.Solver
import kotlin.math.abs

object Day1Solver : Solver {
  override fun solve(sequence: Sequence<String>): String {
    val lefts = arrayListOf<Int>()
    val rights = arrayListOf<Int>()
    sequence
      .forEach {
        val (left, right) = it.split("   ").map { it2 -> it2.toInt() }
        lefts.add(left)
        rights.add(right)
      }
    lefts.sort()
    rights.sort()

    val rightsCounts = rights
      .groupingBy { it }
      .eachCount()

    return part1(lefts, rights) + ", " + part2(lefts, rightsCounts)
  }

  private fun part2(
    lefts: ArrayList<Int>,
    rightsCounts: Map<Int, Int>,
  ): String {
    val leftToRightSimilarity = lefts.sumOf {
      it * (rightsCounts[it] ?: 0)
    }
    return leftToRightSimilarity.toString()
  }

  private fun part1(
    lefts: ArrayList<Int>,
    rights: ArrayList<Int>,
  ) = List(lefts.size) { index ->
    abs(lefts[index] - rights[index])
  }.sum().toString()
}
