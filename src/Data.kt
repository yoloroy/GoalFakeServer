package com.goalteam

import com.goalteam.FakeDreams.dreams
import com.goalteam.model.Challenge
import com.goalteam.model.Dream
import com.goalteam.model.DreamDetail

object Data {

    fun getDreamsByTags(badTags: List<String>): List<Dream> {
        val tags = badTags.map(String::toLowerCase)

        return dreams
            .filter { it.tags.any { tag -> tag.toLowerCase() in tags } }
            .sortedBy { (it.tags intersect tags.toSet()).size }
            .map { Dream(it) }
    }

    fun getDreamDetailById(dreamId: String): DreamDetail = dreams
        .find { it.id == dreamId }!!
}

@Suppress("SpellCheckingInspection")
internal object FakeDreams {
    private var idCounter = Int.MIN_VALUE
    private val id get() = idCounter++.toString()

    val dreams = listOf(
        DreamDetail(
            id = id,
            name = "French Onion Soup | Basics with Babish",
            description = "French onion soup can vbe a little fussy, time consuming, and tear-inducing, but if you've got a few hours on a rainy Saturday, there are few better ways to spend it than in the pursuit of this classic, comforting gratineé",
            tags = listOf("test", "Basics with Babish", "Cooking", "Onion soup"),
            challenges = listOf(
                Challenge(
                    no = 1,
                    id = id,
                    name = "Obtaining Onions",
                    description = "For four servings you will need three pounds of Spanish onions\nhttps://images.delightedcooking.com/spanish-onions.jpg"
                ),
                Challenge(
                    no = 2,
                    id = id,
                    name = "Cutting onions",
                    description = "Cut the onions into half rings"
                ),
                Challenge(
                    no = 3,
                    id = id,
                    name = "Cooking",
                    description = "Continuation you can see on Babish's YT ~please, somebody, invite him to our community ;)~\nhttps://www.youtube.com/watch?v=1qRir364aNk&feature=share"
                )
            )
        ),
        DreamDetail(
            id = id,
            name = "Goal tutorial",
            description = "Learning how to use Goal app",
            tags = listOf("Getting started"),
            challenges = listOf(
                Challenge(
                    "$idCounter",
                    "Your first challenge",
                    "To complete your challenge, you need to click on ‘done’ button at bottom right corner of challenge card",
                    1
                ),
                Challenge(
                    "$idCounter",
                    "Your second challenge",
                    "You can see your fulfilled dreams in Profile tab",
                    2
                ),
                Challenge("$idCounter", "...", "...", 3)
            )
        ),
        DreamDetail(
            id = id,
            name = "Your first fulfilled dream",
            description = "It just part of tutorial",
            tags = listOf("Getting started"),
            challenges = listOf()
        )
    )
}
