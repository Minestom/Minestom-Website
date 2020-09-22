package com.minestom.website

import io.ktor.application.*
import io.ktor.html.*
import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.util.*
import io.ktor.webjars.*
import kotlinx.css.*
import kotlinx.css.properties.TextDecoration
import kotlinx.html.*

fun HTML.index() {
    head {
        title("Hello from Minestom!")
        // TODO: Move this content to It's own template
        meta {
            charset = "utf-8"
        }
        meta {
            name = "viewport"
            content = "width=device-width, initial-scale=1, shrink-to-fit=no"
        }
        link {
            rel = "stylesheet"
            href = "/assets/bootstrap/css/bootstrap.css"
        }
        // End

        // TODO: Allow pages to have custom head features
        link {
            href = "https://fonts.googleapis.com/css2?family=Bangers&display=swap"
            rel = "stylesheet"
        }


    }
    body {
        // TODO: Move this content to its own template
        nav(classes = "navbar navbar-expand-lg navbar-light fixed-top") {
            div(classes = "container") {
                // Minestom Logo in Navbar
                a(classes = "navbar-brand") {
                    href = "#"
                    img {
                        src = "/assets/logo-single.png"
                        width = "32"
                        height = "32"
                    }
                    span {
                        style {
                            color = Color("#212529")
                            marginLeft = LinearDimension("20px")
                            textTransform = TextTransform.capitalize
                            fontFamily = "'Bangers', cursive"
                            fontWeight = FontWeight("200")
                            fontSize = LinearDimension("1rem")
                            textDecoration = TextDecoration.none
                        }
                        +"Minestom"
                    }
                }
                // Button for smaller devices
                button(classes = "navbar-toggler") {
                    type = ButtonType.button
                    attributes["data-toggle"] = "collapse"
                    attributes["data-target"] = "#navbarItems"
                    attributes["aria-controls"] = "navbarItems"
                    attributes["aria-expanded"] = "false"
                    attributes["aria-label"] = "Toggle navigation"
                    span(classes = "navbar-toggler-icon")
                }
                // Navbar items
                div(classes = "navbar-collapse collapse") {
                    id = "navbarItems"
                    ul(classes = "nav navbar-nav ml-auto") {
                        li(classes = "nav-item") {
                            a(classes = "nav-link") {
                                href = "#"
                                +"Home"
                            }
                        }
                        li(classes = "nav-item") {
                            a(classes = "nav-link") {
                                href = "#"
                                +"Wiki"
                            }
                        }
                        li(classes = "nav-item") {
                            a(classes = "nav-link") {
                                href = "#"
                                +"About"
                            }
                        }
                    }
                }
            }
        }

        // ACTUAL CONTENT
        // TODO: Move this content to it's own template (Definitely)
        header {
            style {
                background = "linear-gradient(155deg, rgba(255,166,0,1) 0%, rgba(255,119,0,1) 100%)"
                paddingTop = LinearDimension("52px")
                borderBottom = "1px solid"
            }
            div(classes = "container") {
                div(classes = "row") {
                    div(classes = "col-md-1") {
                    }
                    div(classes = "col-md-10") {
                        h1(classes = "text-center") {
                            style {
                                textTransform = TextTransform.capitalize
                                fontWeight = FontWeight("500")
                                fontSize = LinearDimension("6rem")
                                textDecoration = TextDecoration.none
                            }
                            +"Minestom"
                        }
                        p(classes = "text-center") {
                            style {
                                fontSize = LinearDimension("2rem")
                                paddingTop = LinearDimension("15px")
                            }
                            +"The next generation of Minecraft: Java Edition servers."
                        }
                    }
                    div(classes = "col-md-1") {
                    }
                }
            }
        }
        section {
            div(classes = "container-fluid") {
                style {
                    backgroundColor = Color("#CCCCCC")
                }
                div(classes = "container") {
                    div(classes = "row") {
                        a(classes = "col-2 text-center") {
                            style {
                                padding = "20px"
                            }
                            href = "#"
                            img {
                                src = "/assets/bootstrap-icons/icons/code-slash.svg"
                                width = "64"
                                height = "64"
                            }
                            p {
                                +"Code"
                            }
                        }
                        div(classes = "col-2") {

                        }
                        div(classes = "col-2") {

                        }
                        div(classes = "col-2") {

                        }
                        div(classes = "col-2") {

                        }
                        div(classes = "col-2") {

                        }
                    }
                }
            }
        }

        div(classes = "container") {
            a {
                +"Minestom is a pretty cool project"
            }
        }
        // END OF ACTUAL CONTENT

        // Script tags
        // TODO: Move this content to it's own template
        script {
            src = "/assets/jquery/jquery.js"
        }
        script {
            src = "/assets/popper.js/popper.js"
        }
        script {
            src = "/assets/bootstrap/js/bootstrap.js"
        }
    }
}

fun Application.main() {
    install(Webjars) {
        path = "/assets/"
    }
    routing {
        get("/") {
            call.respondHtml(HttpStatusCode.OK, HTML::index)
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
