package com.jmfg.training.ktor.models

import kotlinx.serialization.Serializable

@Serializable
data class TVCharacter(
    val id: Int,
    val name: String,
    val image: String,
    val about: String,
    val rating: Double,
    val isFavorite: Boolean,
    val month: String,
    val day: String,
    val family: List<String>,
    val abilities: List<String>,
    val appearances: List<String>
)
