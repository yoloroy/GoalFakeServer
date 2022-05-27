package com.goalteam.model

import com.goalteam.model.Challenge

data class DreamDetail(
    val challenges: List<Challenge>,
    val description: String,
    val id: String,
    val name: String,
    val tags: List<String>
)
