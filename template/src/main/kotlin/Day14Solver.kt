package com.github.micheljung.adventofcode.y2023

import com.github.micheljung.adventofcode.common.CachingInputProvider
import com.github.micheljung.adventofcode.common.Solver

object Day14Solver : Solver {
  override fun solve(sequence: Sequence<String>): String {
    TODO("Not yet implemented")
  }
}

fun main() {
  val example = """
    
  """.trimIndent()
  println(Day14Solver.solve(example.lineSequence()))
  println(Day14Solver.solve(CachingInputProvider(2023, 14).get().lineSequence()))
}
