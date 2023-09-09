dependencies {
    implementation(project(":dangle-common"))
    implementation(project(":dangle-domain"))
    implementation(project(":dangle-usecase"))

    implementation("org.springframework.cloud:spring-cloud-starter-openfeign:4.0.3")
}

tasks.bootJar { enabled = false }
tasks.jar { enabled = true }
