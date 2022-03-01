plugins {
    id("kotlin-conventions")
    id("testing-conventions")
    id("spring-conventions")
}

val boostrapVersion: String by project
val fontawesomeVersion: String by project
val mustacheVersion: String by project

dependencies {
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")

    implementation("org.webjars:bootstrap:${boostrapVersion}")
    implementation("org.webjars:font-awesome:${fontawesomeVersion}")
    implementation("org.webjars.npm:mustache:${mustacheVersion}")

    developmentOnly("org.springframework.boot:spring-boot-devtools")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}
