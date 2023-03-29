plugins {
    `java-library`
}

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.2")
    testRuntimeOnly("org.junit.platform:junit-platform-jfr") {
        because("it adds support for JUnit's JFR events")
    }
}

tasks.test {
    useJUnitPlatform()

    // Enable JFR
    jvmArgumentProviders += CommandLineArgumentProvider {
        listOf(
            "-XX:StartFlightRecording=filename=${reports.junitXml.outputLocation.asFile.get().absolutePath},dumponexit=true",
            "-XX:FlightRecorderOptions=stackdepth=1024"
        )
    }
}
