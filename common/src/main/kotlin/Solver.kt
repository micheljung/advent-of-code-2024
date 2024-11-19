package com.github.micheljung.adventofcode.common

@FunctionalInterface
interface Solver {
  fun solve(sequence: Sequence<String>): String
}
