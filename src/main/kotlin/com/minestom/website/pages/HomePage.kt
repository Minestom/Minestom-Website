package com.minestom.website.pages

import com.minestom.website.respondCss
import com.minestom.website.style
import com.minestom.website.templating.GlobalTemplate
import com.minestom.website.templating.body.NavigationTemplate
import io.ktor.application.*
import io.ktor.html.*
import io.ktor.http.*
import io.ktor.routing.*
import kotlinx.css.*
import kotlinx.css.properties.TextDecoration
import kotlinx.html.*

fun Routing.home() {
    get("/") {
        call.respondHtmlTemplate(GlobalTemplate(), HttpStatusCode.OK) {
            htmlHead {
                title {
                    +"Minestom | Home"
                }
                customHeadTags {
                    link {
                        rel = "stylesheet"
                        href = "/assets/home/home.css"
                    }
                }
            }

            navigation {
                currentPage = NavigationTemplate.CurrentPage.HOME
            }

            subHeader {
                div(classes = "container") {
                    div(classes = "row") {
                        div(classes = "col-md-12 text-center") {
                            h1 {
                                style {
                                    textTransform = TextTransform.capitalize
                                    fontWeight = FontWeight("500")
                                    fontSize = LinearDimension("6rem")
                                    textDecoration = TextDecoration.none
                                }
                                +"Minestom"
                            }

                            p {
                                style {
                                    fontSize = LinearDimension("2rem")
                                    paddingTop = LinearDimension("15px")
                                }
                                +"The next generation of Minecraft: Java Edition servers."
                            }
                        }
                    }
                }
            }

            firstSection {
                style {
                    backgroundColor = Color("#EEEEEE")
                }
                div(classes = "container") {
                    div(classes = "row") {
                        a(classes = "col-2 text-center widget") {
                            style {
                                textDecoration = TextDecoration.none
                                color = Color.inherit
                                paddingTop = LinearDimension("16px")
                            }
                            href = "https://github.com/Minestom/Minestom"
                            img {
                                src = "/assets/bootstrap-icons/1.0.0/icons/code.svg"
                                width = "64"
                                height = "64"
                            }
                            p {
                                +"Code"
                            }
                        }
                        a(classes = "col-2 text-center widget") {
                            style {
                                textDecoration = TextDecoration.none
                                color = Color.inherit
                                paddingTop = LinearDimension("16px")
                            }
                            href = "/wiki/"
                            img {
                                src = "/assets/bootstrap-icons/1.0.0/icons/book.svg"
                                width = "64"
                                height = "64"
                            }
                            p {
                                +"Wiki"
                            }
                        }
                        a(classes = "col-2 text-center widget") {
                            style {
                                textDecoration = TextDecoration.none
                                color = Color.inherit
                                paddingTop = LinearDimension("16px")
                            }
                            href = "/forums/"
                            img {
                                src = "/assets/bootstrap-icons/1.0.0/icons/chat.svg"
                                width = "64"
                                height = "64"
                            }
                            p {
                                +"Forums"
                            }
                        }
                        a(classes = "col-2 text-center widget") {
                            style {
                                textDecoration = TextDecoration.none
                                color = Color.inherit
                                paddingTop = LinearDimension("16px")
                            }
                            href = "/extensions/"
                            img {
                                src = "/assets/bootstrap-icons/1.0.0/icons/layers.svg"
                                width = "64"
                                height = "64"
                            }
                            p {
                                +"Extensions"
                            }
                        }
                        a(classes = "col-2 text-center widget") {
                            style {
                                textDecoration = TextDecoration.none
                                color = Color.inherit
                                paddingTop = LinearDimension("16px")
                            }
                            href = "https://trello.com/b/4ysvj5hT/minestom"
                            img {
                                src = "/assets/bootstrap-icons/1.0.0/icons/people.svg"
                                width = "64"
                                height = "64"
                            }
                            p {
                                +"Trello"
                            }
                        }
                        a(classes = "col-2 text-center widget") {
                            style {
                                textDecoration = TextDecoration.none
                                color = Color.inherit
                                paddingTop = LinearDimension("16px")
                            }
                            href = "https://minestom.com/wiki/"
                            img {
                                src = "/assets/bootstrap-icons/1.0.0/icons/wallet.svg"
                                width = "64"
                                height = "64"
                            }
                            p {
                                +"Donate"
                            }
                        }
                    }
                }
            }
        }
    }
    get("/assets/home/home.css") {
        call.respondCss {
            rule("a.widget:hover") {
                backgroundColor = Color("#CCCCCC")
            }
        }
    }

}