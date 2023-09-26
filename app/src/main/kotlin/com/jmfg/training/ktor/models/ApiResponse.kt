package com.jmfg.training.ktor.models

import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse(
    val success: Boolean,
    val message: String? = null,
    val characters: List<TVCharacter> = emptyList(),
    val prevPage: Int? = if (characters.isNotEmpty()) 1 else null,
    val nextPage: Int? = if (characters.isNotEmpty()) 1 else null
)
