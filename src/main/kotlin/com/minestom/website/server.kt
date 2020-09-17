package com.minestom.website

import io.ktor.application.*
import io.ktor.html.*
import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.routing.*
import io.ktor.util.*
import kotlinx.html.*

fun HTML.index() {
    head {
        title("Hello from Minestom!")
    }
    body {
        div {
            +"Minestom is a pretty cool project"
        }
    }
}

fun Application.main() {
    routing {
        get("/") {
            call.respondHtml(HttpStatusCode.OK, HTML::index)
        }
        static("/static/") {
            resources("/static/")
        }
    }
}

@OptIn(KtorExperimentalAPI::class)
val Application.envKind get() = environment.config.property("ktor.environment").getString()
val Application.isDev get() = envKind == "dev"
val Application.isProd get() = envKind == "prod"
