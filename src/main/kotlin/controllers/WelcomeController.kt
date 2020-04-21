package com.dev4dum.site.controllers

import com.dev4dum.site.entities.Video
import com.dev4dum.site.entities.Videos
import com.fasterxml.jackson.databind.util.JSONPObject
import dev.alpas.http.HttpCall
import dev.alpas.ozone.latest
import dev.alpas.routing.Controller
import dev.alpas.toJson
import me.liuwj.ktorm.dsl.eq
import me.liuwj.ktorm.entity.filter
import me.liuwj.ktorm.entity.take
import me.liuwj.ktorm.entity.toList
import org.apache.commons.lang3.ObjectUtils


class WelcomeController : Controller() {
    fun index(call: HttpCall) {
        call.render("welcome")
    }

    fun loadvideos(call: HttpCall) {

        if(call.isAjax) {

            var id = call.jsonBody?.get("id").toString().toInt()


            val videos = id?.let {
                Videos
                    .latest()
                    .filter { it.cat_id eq id }
                    .take(4)
                    .toList()
            }

            if (videos != null) {
                call.reply(videos.toJson())
            }
        }
    }


    fun show(call: HttpCall) {
        call.render("resources")
    }

    fun dadjokes(call: HttpCall) {
        call.render("dadjokes")
    }
}