package com.jmfg.training.ktor

import com.jmfg.training.ktor.plugins.configureDefaultHeaders
import com.jmfg.training.ktor.plugins.configureKoin
import com.jmfg.training.ktor.plugins.configureMonitoring
import com.jmfg.training.ktor.plugins.configureRouting
import com.jmfg.training.ktor.plugins.configureSerialization
import com.jmfg.training.ktor.plugins.configureStatus
import io.ktor.server.application.Application
import io.ktor.server.engine.ApplicationEngineEnvironmentBuilder
import io.ktor.server.engine.applicationEngineEnvironment
import io.ktor.server.engine.connector
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

fun main() {
    val env = applicationEngineEnvironment {
        envConfig()
    }

    embeddedServer(Netty, env).start(wait = true)
}

fun ApplicationEngineEnvironmentBuilder.envConfig() {
    developmentMode = true
    module {
        module()
    }
    connector {
        port = 8080
    }
    watchPaths = listOf("classes", "resources")
}
fun Application.module() {
    configureKoin()
    configureRouting()
    configureMonitoring()
    configureSerialization()
    configureDefaultHeaders()
    configureStatus()
}
