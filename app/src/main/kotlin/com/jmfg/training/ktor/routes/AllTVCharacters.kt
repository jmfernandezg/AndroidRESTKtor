package com.jmfg.training.ktor.routes

import com.jmfg.training.ktor.models.ApiResponse
import com.jmfg.training.ktor.repository.TVCharacterRepository
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import org.koin.ktor.ext.inject

fun Route.getAllTVCharacters() {
    val tvCharacterRepository: TVCharacterRepository by inject()

    get("/all") {
        runCatching {
            val page = call.request.queryParameters["page"]?.toInt() ?: 1

            require(page in 1..10) {
                "Only numbers between 1 and 10 are allowed"
            }

            call.respond(
                tvCharacterRepository.getAll(page)
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
