plugins {
    id("base-conventions")
}

kotlin {
    explicitApi()
}

dependencies {
    implementation(projects.engine.game)
    implementation(projects.engine.map)
}
