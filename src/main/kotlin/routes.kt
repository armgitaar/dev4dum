package com.dev4dum.site

import com.dev4dum.site.controllers.WelcomeController
import com.dev4dum.site.controllers.VideoController
import dev.alpas.Environment
import dev.alpas.auth.authRoutes
import dev.alpas.routing.RouteGroup
import dev.alpas.routing.Router

fun Router.addRoutes(env: Environment) = apply {
    group {
        webRoutesGroup()
    }.middlewareGroup("web")

    authRoutes(allowRegistration = env("ALLOW_REGISTRATION", false), requireEmailVerification = false, allowPasswordReset = env("ALLOW_PASSWORD_RESET", false), addHomeRoute = false)
    apiRoutes()
}

private fun RouteGroup.webRoutesGroup() {
    get("/", WelcomeController::class).name("welcome")
    post("/load-videos", WelcomeController::loadvideos).name("loadvideos")
    get("/resources", WelcomeController::show).name("resources")
    get("/dadjokes", WelcomeController::dadjokes).name("dadjokes")
    get("/<cat-id>/<video-id>/<video-title>", VideoController::video).name("video")

    // register more web routes here
}

private fun Router.apiRoutes() {
    // register API routes here
}
