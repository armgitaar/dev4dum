package com.dev4dum.site.controllers

import com.dev4dum.site.entities.Videos
import dev.alpas.http.HttpCall
import dev.alpas.routing.Controller


class WelcomeController : Controller() {
    fun index(call: HttpCall) {


        val ytVideos = Videos.getVideos(1)
        val latestVideos = Videos.latestVideos()

        call.render("welcome", mapOf("latestVideos" to latestVideos))

        println(ytVideos)
        println(latestVideos)
    }

}
