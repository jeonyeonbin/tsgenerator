import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
}

tasks.withType<Test> {
    useJUnitPlatform() {
        includeEngines("junit-jupiter")
    }
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))

    implementation(project(":core"))

    implementation("com.github.ntrrgc:ts-generator:1.1.1")
    implementation("org.reflections:reflections:0.9.12")
    implementation("org.springframework.boot:spring-boot-starter-web:2.5.0")


    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5:1.3.50")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.2")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.7.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.2")

    testImplementation("org.springframework.boot:spring-boot-starter-test:2.5.0")
}