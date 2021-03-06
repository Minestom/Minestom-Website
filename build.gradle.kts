import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "com.minestom"
version = "1.0.0"

val ktorVersion: String by project
val kotlinVersion: String by project
val slf4jVersion: String by project
val log4j2Version: String by project

plugins {
    kotlin("jvm") version "1.4.10"
    application
    id("com.github.johnrengelman.shadow") version "6.0.0"
}

repositories {
    mavenCentral()
    jcenter()
    maven("https://dl.bintray.com/kotlin/ktor")
    maven("https://kotlin.bintray.com/kotlin-js-wrappers")
}

dependencies {
    // Ktor
    // Use Netty as the embedded server.
    implementation("io.ktor:ktor-server-netty:$ktorVersion")
    // Allows us to create HTML using a Kotlin DSL
    implementation("io.ktor:ktor-html-builder:$ktorVersion")
    // Allows us to create CSS using a Kotlin DSL
    implementation("org.jetbrains:kotlin-css-jvm:1.0.0-pre.116-kotlin-1.4.10")
    // Webjars are great (www.webjars.org), we can use client-side web libraries!
    implementation("io.ktor:ktor-webjars:$ktorVersion")
    // Use Gson for handling requests, if we ever have to
    implementation("io.ktor:ktor-gson:$ktorVersion")

    // Webjars
    // Let's use Bootstrap (https://getbootstrap.com/)
    implementation("org.webjars:bootstrap:4.5.2")
    // Let's use Bootstrap Icons (https://icons.getbootstrap.com/)
    implementation("org.webjars.npm:bootstrap-icons:1.0.0")

    // Logging
    implementation("org.slf4j:slf4j-api:$slf4jVersion")
    implementation("org.apache.logging.log4j:log4j-core:$log4j2Version")
    implementation("org.apache.logging.log4j:log4j-slf4j-impl:$log4j2Version")
}

// Configuration
application {
    mainClassName = "io.ktor.server.netty.EngineMain"
}

tasks.withType<KotlinCompile> {
    // Opt into the Experimental API
    kotlinOptions.freeCompilerArgs += "-Xopt-in=kotlin.RequiresOptIn"
    // Tell Kotlin to compile for a JVM 11
    kotlinOptions.jvmTarget = "11"
}

tasks.withType<Jar> {
    archiveVersion.set("")
    archiveClassifier.set("fat")
    manifest {
        mapOf(
            "Main-Class" to application.mainClassName
        )
    }
}