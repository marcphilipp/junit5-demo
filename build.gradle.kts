plugins {
    java
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.4.0")
}

tasks.test {
    useJUnitPlatform()
}
