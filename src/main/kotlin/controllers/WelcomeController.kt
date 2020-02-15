package com.dev4dum.site.controllers

import com.dev4dum.site.entities.Video
import com.dev4dum.site.entities.Videos
import dev.alpas.http.HttpCall
import dev.alpas.routing.Controller
import org.apache.commons.lang3.ObjectUtils


class WelcomeController : Controller() {
    fun index(call: HttpCall) {


        // get max category value, start at 1 - pull latest 4 videos, add to master list. If category not present, then ignore, and continue
        val videosList: MutableList<Video> = mutableListOf()

        var vidProgression = 1

        while (Videos.maxCatId!! + 1 > vidProgression) {
            if (vidProgression in Videos.catIds) {

                var ytVideos = Videos.getVideos(vidProgression)
                videosList += ytVideos
                vidProgression += 1
                continue

            } else {
                vidProgression += 1
                continue
            }

        }

        call.render("welcome", "videosList" to videosList)


    }


}
