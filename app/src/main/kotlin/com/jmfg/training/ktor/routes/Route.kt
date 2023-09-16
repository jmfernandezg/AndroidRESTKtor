package com.jmfg.training.ktor.routes

import io.ktor.http.HttpStatusCode
import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import net.datafaker.Faker

val faker = Faker()

fun Route.root() {
    get("/") {
        call.respond(
            status = HttpStatusCode.OK,
            message = faker.gameOfThrones().quote()
        )
    }
}
