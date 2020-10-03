package com.minestom.website.templating.head

import io.ktor.html.*
import kotlinx.html.*

class HeadTemplate : Template<HEAD> {
    val title = Placeholder<TITLE>()
    val customHeadTags = Placeholder<HEAD>()

    override fun HEAD.apply() {
        // Title of the page
        title {
            insert(this@HeadTemplate.title)
        }
        // Bootstrap meta and stylesheet
        meta {
            charset = "utf-8"
        }
        meta {
            name = "viewport"
            content = "width=device-width, initial-scale=1, shrink-to-fit=no"
        }
        link {
            rel = "stylesheet"
            href = "/assets/bootstrap/4.5.2/css/bootstrap.css"
        }
        link {
            rel = "stylesheet"
            href = "/assets/global.css"
        }
        link {
            rel = "icon"
            href = "/assets/favicon.ico"
        }

        // Custom head tags (custom fonts, scripts etc.)
        insert(customHeadTags)
    }
}