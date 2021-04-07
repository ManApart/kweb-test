import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.32"
}

group = "me.austin"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://jitpack.io")
    jcenter()
}

dependencies {
    implementation("com.github.kwebio:kweb-core:0.8.8")
    implementation("org.slf4j:slf4j-simple:1.7.30")

    testImplementation(kotlin("test-testng"))
}

tasks.test {
    useTestNG()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "11"
}
