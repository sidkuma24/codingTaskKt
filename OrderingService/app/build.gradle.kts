/*
 * This file was generated by the Gradle 'init' task.
 */

plugins {
    id("OrderingService.kotlin-application-conventions")
}

repositories {
    jcenter()
    maven("https://dl.bintray.com/kotlin/kotlinx/")
}

dependencies {
    implementation("org.jetbrains.kotlinx", "kotlinx-cli", "0.2")
    implementation("org.apache.kafka:kafka-clients:2.0.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.3.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.3.1")
}
tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}


application {
    // Define the main class for the application.
    mainClass.set("OrderingService.app.AppKt")
}





val jar by tasks.getting(Jar::class) {
    manifest {
        attributes["Main-Class"] = "OrderingService.app.AppKt"
    }
    from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) }){
        exclude("META-INF/*.RSA", "META-INF/*.SF", "META-INF/*.DSA")
    }}


