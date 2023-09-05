dependencies {
    api("org.slf4j:slf4j-api:1.7.25")
}

tasks.bootJar { enabled = false }
tasks.jar { enabled = true }
