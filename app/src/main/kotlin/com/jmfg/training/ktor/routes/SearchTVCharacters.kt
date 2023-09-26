package com.jmfg.training.ktor.routes

import com.jmfg.training.ktor.models.ApiResponse
import com.jmfg.training.ktor.repository.TVCharacterRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.searchTVCharacters() {
    val tvCharacterRepository: TVCharacterRepository by inject()

    get("/search") {
        runCatching {
            val name = call.request.queryParameters["name"]
                ?: throw IllegalArgumentException("Name is required")

            tvCharacterRepository.search(name).let {
                call.respond(
                    message = it,
                    status = if (it.success) HttpStatusCode.OK else HttpStatusCode.NotFound
                )
            }

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
