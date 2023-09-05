dependencies {
    implementation(project(":dangle-common"))
    implementation(project(":dangle-domain"))

    implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
    implementation("org.springframework.cloud:spring-cloud-starter-circuitbreaker-resilience4j")
}

tasks.bootJar { enabled = false }
tasks.jar { enabled = true }
