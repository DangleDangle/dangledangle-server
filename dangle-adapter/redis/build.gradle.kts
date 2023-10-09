dependencies {
    implementation(project(":dangle-common"))
    implementation(project(":dangle-domain"))

    api("org.springframework.boot:spring-boot-starter-data-redis")
    api("it.ozimov:embedded-redis:0.7.3") {
        exclude(group = "org.slf4j", module = "slf4j-simple")
    }
}

tasks.bootJar { enabled = false }
tasks.jar { enabled = true }
