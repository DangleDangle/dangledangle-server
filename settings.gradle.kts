rootProject.name = "dangle"

include(":dangle-common")
include(":dangle-domain")
include(":dangle-usecase")
include(":dangle-api")

// adapter
include(":dangle-adapter-persistence")
include(":dangle-adapter-http")
include(":dangle-adapter-redis")
project(":dangle-adapter-persistence").projectDir = file("dangle-adapter/persistence")
project(":dangle-adapter-http").projectDir = file("dangle-adapter/http")
project(":dangle-adapter-redis").projectDir = file("dangle-adapter/redis")
