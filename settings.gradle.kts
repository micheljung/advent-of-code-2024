pluginManagement {
  repositories {
    mavenCentral()
    gradlePluginPortal()
  }
}

rootProject.name = "advent-of-code-2024"

dependencyResolutionManagement {
  repositories {
    mavenCentral()
  }
}

include(
  "app",
  "common",
  "template",
  "y2023",
)
