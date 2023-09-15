package com.jmfg.training.ktor

import com.jmfg.training.ktor.plugins.configureRouting
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    val env = applicationEngineEnvironment {
        envConfig()
    }

    embeddedServer(Netty, env).start(wait = true)
}

fun ApplicationEngineEnvironmentBuilder.envConfig() {
    module {
        module()
    }
    connector {
        port = 8080
    }
}
fun Application.module() {
    configureRouting()


}