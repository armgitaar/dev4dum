package com.dev4dum.site.controllers

import com.dev4dum.site.entities.Videos
import dev.alpas.http.HttpCall
import dev.alpas.orAbort
import dev.alpas.ozone.latest
import dev.alpas.routing.Controller
import me.liuwj.ktorm.dsl.eq
import me.liuwj.ktorm.entity.filter
import me.liuwj.ktorm.entity.toList


class VideoController : Controller() {
    fun video(call: HttpCall) {

        val id = call.longParam("cat-id").orAbort()
        val ytid = call.stringParam("video-id").orAbort()

        val videos = Videos
            .latest()
            .filter { it.cat_id eq id.toInt() }
            .toList()

        val highlight = videos.find { it.video_key.toLowerCase() == ytid }

        call.render("videodetails", mapOf("videos" to videos, "ytid" to ytid, "highlight" to highlight))
    }
}