package com.goalteam.model

import kotlinx.serialization.Serializable

@Serializable
data class Challenge(
    val description: String,
    val id: String,
    val name: String,
    val no: Int
)
