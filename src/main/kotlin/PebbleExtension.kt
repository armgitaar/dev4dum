package com.dev4dum.site

import dev.alpas.Application
import dev.alpas.view.ConditionalTags
import dev.alpas.view.extensions.PebbleExtension
import com.dev4dum.site.entities.User
import dev.alpas.config
import com.dev4dum.site.configs.AppConfig

@Suppress("unused")
class PebbleExtension : PebbleExtension {
    override fun register(app: Application, conditionalTags: ConditionalTags) {

        conditionalTags.add("admin") {
            call.isAuthenticated && call.caller<User>().isAdmin(call.config<AppConfig>().adminEmails)
        }
    }
}