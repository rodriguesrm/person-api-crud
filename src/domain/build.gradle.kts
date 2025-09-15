plugins {
    id("java")
}

group = "rsoft"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

//    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("jakarta.validation:jakarta.validation-api:3.0.2")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

}

tasks.test {
    useJUnitPlatform()
}