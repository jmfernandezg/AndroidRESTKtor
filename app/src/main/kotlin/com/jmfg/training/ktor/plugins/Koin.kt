package com.jmfg.training.ktor.plugins

import com.jmfg.training.ktor.di.koinModule
import io.ktor.server.application.Application
import io.ktor.server.application.install
import org.koin.ktor.plugin.Koin
import org.koin.logger.SLF4JLogger

fun Application.configureKoin() {
    install(Koin) {
        SLF4JLogger()
        modules(koinModule)
    }
}
