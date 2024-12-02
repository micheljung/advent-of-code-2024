package com.github.micheljung.adventofcode.y2023

import com.github.micheljung.adventofcode.common.CachingInputProvider
import com.github.micheljung.adventofcode.common.Solver

object Day8Solver : Solver {
  override fun solve(sequence: Sequence<String>): String {
    TODO("Not yet implemented")
  }
}

fun main() {
  val example = """
    
  """.trimIndent()
  println(Day8Solver.solve(example.lineSequence()))
  println(Day8Solver.solve(CachingInputProvider(2023, 8).get().lineSequence()))
}
