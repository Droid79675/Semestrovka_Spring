plugins {
    id("java")
    id("org.springframework.boot") version "2.7.8"
    id("jacoco")
}

apply(plugin = "io.spring.dependency-management")
group = "ru.kpfu.itis.emelyanov"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation ("org.springframework.boot:spring-boot-starter-security")
    implementation ("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation("org.springframework.boot:spring-boot-starter-freemarker")
    implementation("org.springframework.boot:spring-boot-starter-websocket")

    implementation("org.webjars.npm:jquery:3.6.1")
    implementation("org.webjars:bootstrap:5.2.0")
    implementation("org.webjars:webjars-locator-core:0.46")

    implementation("org.webjars:stomp-websocket:2.3.4")
    implementation("org.webjars:sockjs-client:1.5.1")

    implementation("io.jsonwebtoken:jjwt-api:0.11.5")
    implementation("io.jsonwebtoken:jjwt-impl:0.11.5")
    implementation("io.jsonwebtoken:jjwt-jackson:0.11.5")

    implementation("org.postgresql:postgresql:42.5.3")
    compileOnly("org.projectlombok:lombok:1.18.24")

    annotationProcessor("org.projectlombok:lombok:1.18.24")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}