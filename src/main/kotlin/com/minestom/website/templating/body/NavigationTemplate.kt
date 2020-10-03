package com.minestom.website.templating.body

import com.minestom.website.style
import io.ktor.html.*
import kotlinx.css.*
import kotlinx.html.*

class NavigationTemplate : Template<HtmlBlockTag> {
    var currentPage = CurrentPage.HOME

    override fun HtmlBlockTag.apply() {
        nav(classes = "navbar navbar-light navbar-expand-lg") {
            style {
                backgroundColor = Color.transparent
            }
            div(classes = "container") {
                // Minestom Logo in Navbar
                a(classes = "navbar-brand") {
                    href = "#"
                    img {
                        src = "/assets/logo_full_light_bg.png"
                        height = "50"
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
                    style {
                        fontSize = LinearDimension("1.25rem")
                    }
                    div(classes = "navbar-nav ml-auto") {
                        a(classes = "nav-item nav-link") {
                            if (currentPage == CurrentPage.HOME) {
                                classes = classes + "active"
                            }
                            href = "/"
                            +"Home"
                        }
                        a(classes = "nav-item nav-link") {
                            if (currentPage == CurrentPage.EXTENSIONS) {
                                classes = classes + "active"
                            }
                            href = "/extensions/"
                            +"Extensions"
                        }
                        a(classes = "nav-item nav-link") {
                            if (currentPage == CurrentPage.WIKI) {
                                classes = classes + "active"
                            }
                            href = "/wiki/"
                            +"Wiki"
                        }
                        a(classes = "nav-item nav-link") {
                            if (currentPage == CurrentPage.ABOUT) {
                                classes = classes + "active"
                            }
                            href = "/about/"
                            +"About"
                        }
                    }
                }
            }
        }
    }

    enum class CurrentPage {
        HOME,
        WIKI,
        ABOUT,
        EXTENSIONS
    }
}