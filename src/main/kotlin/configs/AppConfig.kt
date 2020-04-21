package com.dev4dum.site.configs

import dev.alpas.AppConfig
import dev.alpas.Environment

@Suppress("unused")
class AppConfig(env: Environment) : AppConfig(env) {

    val adminEmails = env("ADMIN_EMAILS", "").split(",")
}