package com.jmfg.training.ktor.plugins

import com.jmfg.training.ktor.routes.getAllTVCharacters
import com.jmfg.training.ktor.routes.root
import com.jmfg.training.ktor.routes.searchTVCharacters
import io.ktor.server.application.Application
import io.ktor.server.routing.routing

fun Application.configureRouting() {
    routing {
        root()
        getAllTVCharacters()
        searchTVCharacters()
    }
}
