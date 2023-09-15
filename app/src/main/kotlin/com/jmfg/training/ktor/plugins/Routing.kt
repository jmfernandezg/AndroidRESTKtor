package com.jmfg.training.ktor.plugins


import com.github.javafaker.Faker
import io.ktor.http.*
import io.ktor.resources.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.http.content.*
import io.ktor.server.plugins.callloging.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.request.*
import io.ktor.server.resources.*
import io.ktor.server.resources.Resources
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.html.*
import kotlinx.serialization.Serializable
import org.slf4j.event.Level


fun Application.configureRouting() {
    install(Resources)
    install(CallLogging) {
        level = Level.INFO
        filter { call -> call.request.path().startsWith("/") }
    }
    install(ContentNegotiation) {
        json()
    }

    routing {
        staticResources("/", "static") {
            default("index.html")
            preCompressed(CompressedFileType.GZIP)

        }

        get("/") {
            call.respondText("Hello World!")
        }
        get("/redirect") {
            call.respondRedirect("/users/${Faker().name().username()}")
        }
        get("/person") {
            try {
                call.respond(
                    message = Person(name = Faker().name().name(), age = Faker().number().randomDigit()),
                    status = HttpStatusCode.OK
                )
            } catch (e: Exception) {
                call.respond(message = "Error: ${e.message}", status = HttpStatusCode.InternalServerError)
            }
        }
        get("/users") {
            val name = call.request.queryParameters["name"]
            val age = call.request.queryParameters["age"]
            call.respondText("Hello $name! Your Age is $age")
        }
        get("/users/{username}") {
            val name = call.parameters["username"]
            val header = call.request.headers["Connection"]
            if (name == "Admin") {
                call.response.headers.append("Admin", "true")
            }
            call.respondText("Hello $name! Welcome to Ktor: $header")
        }
        get("/welcome") {
            val name = call.request.queryParameters["name"]
            call.respondHtml {
                head {
                    title { +Faker().buffy().quotes() }
                }
                body {
                    h1 { +"Hello from ${Faker().hitchhikersGuideToTheGalaxy().character()}!" }
                    h3 { +"Current Directory is ${System.getProperty("user.dir")}" }


                    name?.let {
                        p {
                            +"Have a nice ${Faker().medical().diseaseName()}! $name  "
                        }

                    } ?: p { +"Query parameter name is missing. You're gonna be ${Faker().funnyName().name()} :)" }

                    img {
                        src = "/images/jb_logo.png"
                        alt = "JB Logo"

                    }
                }
            }
        }
        get<Articles> { article ->
            call.respond("List of articles sorted starting from ${article.sort}")
        }
    }
}

@Serializable
@Resource("/articles")
class Articles(val sort: String? = "new")

@Serializable
@Resource("/person")
data class Person(val name: String, val age: Int)
