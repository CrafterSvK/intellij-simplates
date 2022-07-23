fun config(name: String) = project.findProperty(name).toString()

val ideaVersion = config("ideaVersion")

plugins {
    id("java")
    id("org.jetbrains.kotlin.jvm") version "1.6.20"
    id("org.jetbrains.intellij") version "1.7.0"
}

group = "xyz.janek"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

// Configure Gradle IntelliJ Plugin
// Read more: https://plugins.jetbrains.com/docs/intellij/tools-gradle-intellij-plugin.html
intellij {
    version.set("2022.1")
    type.set("PC") // Target IDE Platform
    plugins.add("org.intellij.intelliLang")
    plugins.add("python-ce")

    // fixme: ideaVersion is empty
//    if (ideaVersion.contains("PC")) {
//        plugins.add("python-ce")
//    } else if (ideaVersion.contains("PY")) {
//        plugins.add("python")
//    } else {
//        plugins.add("PythonCore:221.6008.13")
//    }
}

tasks {
    // Set the JVM compatibility versions
    withType<JavaCompile> {
        sourceCompatibility = "11"
        targetCompatibility = "11"
    }
    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = "11"
    }

    patchPluginXml {
        sinceBuild.set("213")
        untilBuild.set("223.*")
    }

    signPlugin {
        certificateChain.set(System.getenv("CERTIFICATE_CHAIN"))
        privateKey.set(System.getenv("PRIVATE_KEY"))
        password.set(System.getenv("PRIVATE_KEY_PASSWORD"))
    }

    publishPlugin {
        token.set(System.getenv("PUBLISH_TOKEN"))
    }
}

sourceSets["main"].java.srcDirs("src/main/gen")