dependencies {
    implementation(project(":dangle-common"))
    implementation(project(":dangle-domain"))
}

tasks.bootJar { enabled = false }
tasks.jar { enabled = true }
