dependencies {
    implementation(project(":dangle-common"))
    implementation(project(":dangle-domain"))
    implementation(project(":dangle-usecase"))
    implementation(project(":dangle-adapter-persistence"))

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    implementation("io.springfox:springfox-swagger-ui:3.0.0")
}

tasks.bootJar { enabled = false }
tasks.jar { enabled = true }
