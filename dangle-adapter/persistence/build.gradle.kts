dependencies {
    implementation(project(":dangle-common"))
    implementation(project(":dangle-domain"))
    implementation(project(":dangle-usecase"))

    runtimeOnly("com.mysql:mysql-connector-j")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("com.h2database:h2")
}

tasks.bootJar { enabled = false }
tasks.jar { enabled = true }
