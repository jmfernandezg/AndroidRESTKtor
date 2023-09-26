package com.jmfg.training.ktor

import com.jmfg.training.ktor.models.ApiResponse
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class ApplicationTest {

    @Test
    fun `Assert Correct Information in Root Endpoint`() = testApplication {
        application {
            module()
        }
        client.get("/").apply {
            assertEquals(HttpStatusCode.OK, status)
            assertNotNull(bodyAsText())
        }
    }

    @Test
    fun `Assert Correct Information in All Characters Endpoint`() = testApplication {
        application {
            module()
        }
        client.get("/all?page=1").apply {
            assertEquals(HttpStatusCode.OK, status)
            val result = Json.decodeFromString<ApiResponse>(bodyAsText())
            result.characters.forEach {
                println(it)
                assertNotNull(it.name)

                it.appearances.forEach { app ->
                    assertNotNull(app)
                    println(app)

                }
            }
            assertNotNull(result.characters)
        }
    }

    @Test
    fun `Assert Bad Request When Page does not Exist in All Characters Endpoint`() = testApplication {
        application {
            module()
        }
        client.get("/all?page=111").apply {
            assertEquals(HttpStatusCode.BadRequest, status)
            val result = Json.decodeFromString<ApiResponse>(bodyAsText())
            assertEquals(false, result.success)
            assertEquals("Only numbers between 1 and 10 are allowed", result.message)
        }
    }

    @Test
    fun `Assert Not Found When Character does not Exist in All Characters Endpoint`() = testApplication {
        application {
            module()
        }
        client.get("/search?name=joan").apply {
            assertEquals(HttpStatusCode.NotFound, status)
        }
    }

    @Test
    fun `Assert Found When Character does not Exist in All Characters Endpoint`() = testApplication {
        application {
            module()
        }
        client.get("/search?name=a").apply {
            assertEquals(HttpStatusCode.OK, status)
            Json.decodeFromString<ApiResponse>(bodyAsText()).let {
                assertEquals(true, it.success)
                assertNotNull(it.message)
                assertNotNull(it.characters)

            }
        }

    }
}
