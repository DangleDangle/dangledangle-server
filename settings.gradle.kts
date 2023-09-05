rootProject.name = "dangle"

include(":dangle-common")
include(":dangle-domain")
include(":dangle-usecase")
include(":dangle-api")

// adapter
include(":dangle-adapter-persistence")
project(":dangle-adapter-persistence").projectDir = file("dangle-adapter/persistence")
include(":dangle-adapter-http")
project(":dangle-adapter-http").projectDir = file("dangle-adapter/http")
