dependencies {
    implementation(project(":dangle-common"))
}

tasks.bootJar { enabled = false }
tasks.jar { enabled = true }
