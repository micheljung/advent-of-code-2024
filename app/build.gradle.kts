plugins {
  id("aoc.kotlin-conventions")
}

dependencies {
  implementation(project(":common"))
  implementation(project(":y2023"))
  implementation(libs.kotlin.reflect)
}
