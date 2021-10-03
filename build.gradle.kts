import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

allprojects {
    group = "com.jyb"
    version = "0.0.1"
    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "11"
        }
    }
    tasks.withType<Test> {
        useJUnitPlatform()
    }

    repositories {
        mavenCentral()
        maven(url = "https://jitpack.io")
    }
}

subprojects {
    repositories {
        mavenCentral()
    }
}

plugins {
    kotlin("jvm") version "1.4.32" apply false
    groovy
}

java.sourceCompatibility = JavaVersion.VERSION_11

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    implementation("com.github.ntrrgc:ts-generator:1.1.1")
    implementation("org.reflections:reflections:0.9.12")

    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5:1.3.50")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.2")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.7.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.2")
}


