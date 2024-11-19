package com.github.micheljung.adventofcode.common

import java.io.BufferedReader
import java.net.URI
import java.net.URL
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import kotlin.io.path.bufferedReader
import kotlin.io.path.outputStream

interface InputProvider {

  fun get(): BufferedReader

  companion object {
    fun of(year: Int, day: Int) = CachingInputProvider(year, day)
  }
}

class CachingInputProvider(
  private val year: Int,
  private val day: Int,
) : InputProvider {
  override fun get(): BufferedReader {
    val path = cacheDir.resolve("input_${year}_${day}.txt")
    if (!Files.exists(path)) downloadFile(path)
    return path.bufferedReader()
  }

  private fun downloadFile(file: Path) {
    Files.createDirectories(file.parent)
    with(createInputUrl(year, day).openConnection()) {
      setRequestProperty(
        "User-Agent",
        "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36",
      )
      // Required because each user gets its own input
      setRequestProperty(
        "Cookie",
        System.getProperty("adventofcode.cookie")
          ?: error("Please set the system property 'adventofcode.cookie'. You can get the cookie value from your browser after logging into adventofcode.com"),
      )
      getInputStream()
        .use { input ->
          file.outputStream().use { input.copyTo(it) }
        }
    }
  }

  companion object {
    private val cacheDir = Paths.get("build/input-cache")
    private fun createInputUrl(year: Int, day: Int): URL =
      URI.create("https://adventofcode.com/$year/day/$day/input").toURL()
  }
}
