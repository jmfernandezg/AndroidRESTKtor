package com.jmfg.training.ktor.di

import com.jmfg.training.ktor.repository.TVCharacterRepository
import com.jmfg.training.ktor.repository.TVCharacterRepositoryImpl
import org.koin.dsl.module
import kotlin.random.Random

val koinModule = module {
    single<TVCharacterRepository> {
        TVCharacterRepositoryImpl()
    }
    single<Int> {
        Random.nextInt(2, 10)
    }
}
