// Top-level build file where you can add configuration options common to all sub-projects/modules.
@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.com.android.application) apply false
    alias(libs.plugins.com.android.library) apply false
    alias(libs.plugins.org.jetbrains.kotlin.android) apply false
    alias(libs.plugins.com.github.ben.manes.versions)
    alias(libs.plugins.org.jetbrains.kotlin.plugin.serialization) apply false
    alias(libs.plugins.nl.littlerobots.version.catalog.update)
}

buildscript {
    dependencies {
        classpath(libs.io.github.didi.drouter.plugin.proxy)
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
