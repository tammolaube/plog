package com.tammolaube.home

import groovy.io.FileType
import groovy.json.JsonSlurper

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Controller
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
@ConfigurationProperties(prefix="profile")
class Index {

    URL url

    @GetMapping("/")
    String index(Model model) {
        def plog = new JsonSlurper().parseText(url.text)
        model.addAttribute("title", plog.title)
        model.addAttribute("subtitle", plog.subtitle)
        model.addAttribute("picture", plog.picture)
        model.addAttribute("b64impressum", plog.b64impressum)
        model.addAttribute("posts", plog.projects.sort{a,b -> b.date <=> a.date})
        "views/profile"
    }

}
