dependencies {
    implementation(project(":dangle-common"))
    implementation(project(":dangle-domain"))

    api("org.springframework.boot:spring-boot-starter-data-redis")
}

tasks.bootJar { enabled = false }
tasks.jar { enabled = true }
