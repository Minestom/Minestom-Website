package com.minestom.website

import com.minestom.website.pages.home
import com.minestom.website.templating.GlobalTemplate
import com.minestom.website.templating.body.NavigationTemplate
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.html.*
import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.util.*
import io.ktor.webjars.*
import kotlinx.css.CSSBuilder
import kotlinx.html.CommonAttributeGroupFacade
import kotlinx.html.FlowOrMetaDataContent
import kotlinx.html.style

fun Application.main() {
    // Use Gson for negotiating content.
    install(ContentNegotiation) {
        gson { }
    }
    // Use webjars to serve some static web files.
    install(Webjars) {
        path = "/assets/"
    }

    // Define some routes for our content.
    install(Routing) {
        home()
        get("/wiki/") {
            call.respondHtmlTemplate(GlobalTemplate(), HttpStatusCode.OK) {
                htmlHead {
                    title {
                        +"Minestom | Wiki"
                    }
                }
                navigation {
                    currentPage = NavigationTemplate.CurrentPage.WIKI
                }
            }
        }
        get("/about/") {
            call.respondHtmlTemplate(GlobalTemplate(), HttpStatusCode.OK) {
                htmlHead {
                    title {
                        +"Minestom | About"
                    }
                }
                navigation {
                    currentPage = NavigationTemplate.CurrentPage.ABOUT
                }
            }
        }
        get("/extensions/") {
            call.respondHtmlTemplate(GlobalTemplate(), HttpStatusCode.OK) {
                htmlHead {
                    title {
                        +"Minestom | Extensions"
                    }
                }
                navigation {
                    currentPage = NavigationTemplate.CurrentPage.EXTENSIONS
                }

            }
        }

        get("/assets/global.css") {
            call.respondCss {

            }
        }
        static("/assets/") {
            resources("/assets/")
        }
    }
}

// Register CSS
fun FlowOrMetaDataContent.styleCss(builder: CSSBuilder.() -> Unit) {
    style(type = ContentType.Text.CSS.toString()) {
        CSSBuilder().apply(builder).toString()
    }
}

fun CommonAttributeGroupFacade.style(builder: CSSBuilder.() -> Unit) {
    this.style = CSSBuilder().apply(builder).toString().trim()
}

suspend inline fun ApplicationCall.respondCss(builder: CSSBuilder.() -> Unit) {
    this.respondText(CSSBuilder().apply(builder).toString(), ContentType.Text.CSS)
}

@OptIn(KtorExperimentalAPI::class)
val Application.envKind
    get() = environment.config.property("ktor.environment").getString()
val Application.isDev get() = envKind == "dev"
val Application.isProd get() = envKind == "prod"
