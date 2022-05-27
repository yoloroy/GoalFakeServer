package com.goalteam

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.response.*
import io.ktor.routing.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused", "UNUSED_PARAMETER") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    install(ContentNegotiation) {
        gson()
    }

    routing {
        get("/") {
            call.respond("hello")
        }

        get("/dreams") {
            call.request.queryParameters["tags"]?.let {
                val tags = it.split(",")
                call.respond(Data.getDreamsByTags(tags))
            }
        }

        get("/dream/{dreamId}") {
            call.parameters["dreamId"]?.let { dreamId ->
                call.respond(Data.getDreamDetailById(dreamId))
            }
        }
    }
}
