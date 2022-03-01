plugins {
    id("kotlin-conventions")
    id("testing-conventions")
    id("spring-conventions")
}

val loremVersion: String by rootProject.extra

dependencies {
    implementation("com.fasterxml.jackson.module", "jackson-module-kotlin")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactive:1.6.0")


    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions:1.1.5")
    implementation(libs.bundles.lorem)

    developmentOnly("org.springframework.boot:spring-boot-devtools")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

