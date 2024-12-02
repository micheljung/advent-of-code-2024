package com.github.micheljung.adventofcode.y2023

import com.github.micheljung.adventofcode.common.CachingInputProvider
import com.github.micheljung.adventofcode.common.Solver

object Day13Solver : Solver {
  override fun solve(sequence: Sequence<String>): String {
    TODO("Not yet implemented")
  }
}

fun main() {
  val example = """
    
  """.trimIndent()
  println(Day13Solver.solve(example.lineSequence()))
  println(Day13Solver.solve(CachingInputProvider(2023, 13).get().lineSequence()))
}
