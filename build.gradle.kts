// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false

    id("org.jetbrains.kotlin.android") version "2.0.0" apply false
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.0" apply false

    // LA SOLUTION DÉFINITIVE : Hilt 2.55 gère Kotlin 2.0 nativement
    id("com.google.dagger.hilt.android") version "2.55" apply false
}