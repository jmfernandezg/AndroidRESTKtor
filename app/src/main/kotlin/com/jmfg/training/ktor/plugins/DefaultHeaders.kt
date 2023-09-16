package com.jmfg.training.ktor.plugins

import io.ktor.http.HttpHeaders
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.plugins.defaultheaders.DefaultHeaders
import java.time.Duration

fun Application.configureDefaultHeaders() {
    install(DefaultHeaders) {
        val yearInSeconds = Duration.ofDays(365).seconds
        header(name = HttpHeaders.CacheControl, value = "public, max-age=$yearInSeconds, immutable")
    }
}
