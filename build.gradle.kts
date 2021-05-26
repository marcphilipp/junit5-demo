plugins {
    java
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.7.2")
    testImplementation("org.junit.platform:junit-platform-commons:5.0.0")
}

tasks.test {
    useJUnitPlatform()
}
