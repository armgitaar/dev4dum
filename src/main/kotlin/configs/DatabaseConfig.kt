package com.dev4dum.site.configs

import dev.alpas.Environment
import dev.alpas.ozone.ConnectionConfig
import dev.alpas.ozone.DatabaseConfig
import dev.alpas.ozone.MySqlConnection


@Suppress("unused")
class DatabaseConfig(env: Environment) : DatabaseConfig(env) {
    init {
        // Uncomment the following line to add database support in your app
        addConnections(env)
    }

    private fun addConnections(env: Environment) {
        addConnection("mysql", lazy { MySqlConnection(env, ConnectionConfig(extraParams = mapOf("serverTimezone" to "UTC"))) })
    }
}

