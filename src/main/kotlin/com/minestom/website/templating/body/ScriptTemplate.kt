package com.minestom.website.templating.body

import io.ktor.html.*
import kotlinx.html.HtmlBlockTag
import kotlinx.html.script

class ScriptTemplate : Template<HtmlBlockTag> {
    override fun HtmlBlockTag.apply() {
        script {
            src = "/assets/jquery/3.5.1/jquery.slim.js"
        }
        script {
            src = "/assets/popper.js/1.16.0/umd/popper.js"
        }
        script {
            src = "/assets/bootstrap/4.5.2/js/bootstrap.js"
        }
    }

}