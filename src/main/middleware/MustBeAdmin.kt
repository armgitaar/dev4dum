package com.dev4dum.site.middleware

import dev.alpas.Handler
import dev.alpas.Middleware
import com.dev4dum.site.configs.AppConfig
import dev.alpas.exceptions.NotFoundHttpException
import dev.alpas.http.HttpCall
import dev.alpas.routing.Route
import dev.alpas.routing.RouteGroup
import com.dev4dum.site.entities.User
import dev.alpas.config

class MustBeAdmin : Middleware<HttpCall>() {
    override fun invoke(call: HttpCall, forward: Handler<HttpCall>) {
        if (call.isAuthenticated && call.caller<User>().isAdmin(call.config<AppConfig>().adminEmails)) {
            forward(call)
        } else {
            throw NotFoundHttpException()
        }
    }
}

fun RouteGroup.mustBeAdmin() {
    middleware(MustBeAdmin::class)
}

fun Route.mustBeAdmin() {
    middleware(MustBeAdmin::class)
}