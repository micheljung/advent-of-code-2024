package com.github.micheljung.adventofcode.y2024

import com.github.micheljung.adventofcode.common.CachingInputProvider
import com.github.micheljung.adventofcode.common.Solver
import com.github.micheljung.adventofcode.y2023.Day1Solver

object Day2Solver : Solver {
  override fun solve(sequence: Sequence<String>): String {
    TODO("Not yet implemented")
  }
}

fun main() {
  val example = """
    
  """.trimIndent()
  println(Day2Solver.solve(example.lineSequence()))
  println(Day2Solver.solve(CachingInputProvider(2023, 2).get().lineSequence()))
}

