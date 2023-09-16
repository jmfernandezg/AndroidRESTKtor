package com.jmfg.training.ktor.repository

import com.jmfg.training.ktor.models.ApiResponse
import com.jmfg.training.ktor.models.TVCharacter
import net.datafaker.Faker
import kotlin.random.Random

interface TVCharacterRepository {
    val characters: Map<Int, List<TVCharacter>>
    suspend fun getAll(page: Int): ApiResponse

    suspend fun search(name: String): ApiResponse
}

val faker = Faker()
val randomMaxPages = Random.nextInt(2, 10)

class TVCharacterRepositoryImpl : TVCharacterRepository {
    override val characters: Map<Int, List<TVCharacter>> = (1..randomMaxPages).associateWith {
        (1..10).map {
            TVCharacter(
                id = it,
                name = faker.superhero().name(),
                image = faker.internet().image(),
                about = faker.job().position(),
                rating = faker.number().randomDouble(1, 100, 1000),
                isFavorite = Random.nextBoolean(),
                month = faker.date().birthday().toLocalDateTime().month.name,
                day = faker.date().birthday().toLocalDateTime().dayOfMonth.toString(),
                family = (1..randomMaxPages).map { faker.funnyName().name() },
                abilities = (1..randomMaxPages).map { faker.superhero().power() },
                appearances = (1..randomMaxPages).map { faker.book().title() }
            )
        }
    }

    override suspend fun getAll(page: Int): ApiResponse {
        return ApiResponse(
            success = true,
            message = "Success",
            prevPage = if (page > 1) page - 1 else null,
            nextPage = if (page <= randomMaxPages) page + 1 else null,
            characters = characters[page] ?: emptyList()
        )
    }

    override suspend fun search(name: String): ApiResponse {
        return ApiResponse(
            success = true,
            message = "Success",
            characters = characters.values.flatten().filter { it.name.contains(name, ignoreCase = true) }
        )
    }
}
