package com.jmfg.training.ktor.routes

import com.jmfg.training.ktor.models.ApiResponse
import com.jmfg.training.ktor.repository.TVCharacterRepository
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import org.koin.ktor.ext.inject

fun Route.searchTVCharacters() {
    val tvCharacterRepository: TVCharacterRepository by inject()

    get("/search") {
        runCatching {
            val name = call.request.queryParameters["name"]

            call.respond(
                name?.let { tvCharacterRepository.search(it) } ?: throw IllegalArgumentException("Name is required")
            )
        }.onFailure {
            call.respond(
                message = ApiResponse(
                    success = false,
                    message = it.message

                ),
                status = HttpStatusCode.BadRequest
            )
        }
    }
}
