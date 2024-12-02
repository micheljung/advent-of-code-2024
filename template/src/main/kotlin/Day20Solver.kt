package com.github.micheljung.adventofcode.y2023

import com.github.micheljung.adventofcode.common.CachingInputProvider
import com.github.micheljung.adventofcode.common.Solver

object Day20Solver : Solver {
  override fun solve(sequence: Sequence<String>): String {
    TODO("Not yet implemented")
  }
}

fun main() {
  val example = """
    
  """.trimIndent()
  println(Day20Solver.solve(example.lineSequence()))
  println(Day20Solver.solve(CachingInputProvider(2023, 20).get().lineSequence()))
}
