package com.minestom.website.templating

import com.minestom.website.style
import com.minestom.website.templating.body.NavigationTemplate
import com.minestom.website.templating.body.ScriptTemplate
import com.minestom.website.templating.head.HeadTemplate
import io.ktor.html.*
import kotlinx.css.*
import kotlinx.html.*

class GlobalTemplate : Template<HTML> {
    // Head
    val htmlHead = TemplatePlaceholder<HeadTemplate>()

    // Body
    val subHeader = Placeholder<HtmlBlockTag>()
    val navigation = TemplatePlaceholder<NavigationTemplate>()
    val firstSection = Placeholder<HtmlBlockTag>()
    val bodyScripts = TemplatePlaceholder<ScriptTemplate>()

    override fun HTML.apply() {
        head {
            // Insert the Head
            insert(HeadTemplate(), htmlHead)
        }

        body {
            // Header division
            header(classes = "container-fluid") {
                style {
                    background = "linear-gradient(155deg, rgba(0,202,255,1) 0%, rgba(0,255,184,1) 100%)"
                    borderBottom = "1px solid"
                }
                // Insert the Navigation Bar
                insert(NavigationTemplate(), navigation)

                insert(subHeader)
            }

            // First Sector content
            section(classes = "container-fluid") {
                insert(firstSection)
            }

            // Main content
            main {
                div(classes = "container") {
                    a {
                        +"Minestom is a pretty cool project"
                    }
                }
            }

            // Footer content
            footer(classes = "container-fluid") {

            }

            // Insert the script tags
            insert(ScriptTemplate(), bodyScripts)
        }
    }

}