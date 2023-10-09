dependencies {
    implementation(project(":dangle-common"))
    implementation(project(":dangle-domain"))

    compileOnly("org.springframework:spring-context")
}

tasks.bootJar { enabled = false }
tasks.jar { enabled = true }
