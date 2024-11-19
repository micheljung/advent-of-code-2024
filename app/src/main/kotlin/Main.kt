package com.github.micheljung.adventofcode.y2023

import com.github.micheljung.adventofcode.common.InputProvider
import com.github.micheljung.adventofcode.common.Solver
import java.net.Authenticator
import java.net.PasswordAuthentication
import java.time.LocalDate

fun main() {
  setUpProxy()

  val now = LocalDate.now()
  (2023..now.year).forEach { year ->
    runYear(year)
  }
}

private fun runYear(year: Int) {
  (1..25).forEach { day ->
    if (LocalDate.of(year, 12, day).isAfter(LocalDate.now())) return@forEach
    runDay(year, day)
  }
}

private fun runDay(year: Int, day: Int) {
  try {
    val solver =
      Class.forName("com.github.micheljung.adventofcode.y${year}.Day${day}Solver").kotlin.objectInstance as Solver
    run(year, day, solver)
  } catch (e: Throwable) {
    when (e::class) {
      ClassNotFoundException::class,
      NotImplementedError::class,
      -> println("[$year-$day]: Not implemented")

      else -> throw e
    }
  }
}

fun setUpProxy() {
  Authenticator.setDefault(
    object : Authenticator() {
      override fun getPasswordAuthentication(): PasswordAuthentication {
        return PasswordAuthentication(
          System.getProperty("http.proxyUser"),
          System.getProperty("http.proxyPassword").toCharArray(),
        )
      }
    },
  )
}

fun run(year: Int, day: Int, solver: Solver) {
  print("[$year-$day]: ")
  InputProvider.of(year, day).get().useLines { solver.solve(it) }
  println()
}
