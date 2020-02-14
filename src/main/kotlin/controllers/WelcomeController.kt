package com.dev4dum.site.controllers

import com.dev4dum.site.entities.Video
import com.dev4dum.site.entities.Videos
import dev.alpas.http.HttpCall
import dev.alpas.routing.Controller
import org.apache.commons.lang3.ObjectUtils


class WelcomeController : Controller() {
    fun index(call: HttpCall) {


        // get max category value, start at 1 - pull latest 4 videos, add to master list. If category not present, then ignore, and continue
        //itemsList.toMutableList().add(item)

        val videosList: MutableList<Video> = mutableListOf()

        var vidProgression = 1

        print("hi ${Videos.catIds}")

        while (Videos.maxCatId!! + 1 > vidProgression) {
            if (vidProgression in Videos.catIds) {

                var ytVideos = Videos.getVideos(vidProgression)
                videosList += ytVideos
                vidProgression += 1
                continue

            } else {
                vidProgression += 1
                println("hey there")
                continue
            }

        }

        println(videosList)


        //videosList.toMutableList().add(ytVideos)


        call.render("welcome", "videosList" to videosList)


    }


}
