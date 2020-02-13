package com.dev4dum.site.controllers

import dev.alpas.http.HttpCall
import dev.alpas.make
import dev.alpas.ozone.DatabaseConfig
import dev.alpas.ozone.MigratingTable
import dev.alpas.ozone.bigIncrements
import dev.alpas.routing.Controller
import me.liuwj.ktorm.dsl.*
import me.liuwj.ktorm.entity.*

import me.liuwj.ktorm.schema.Table
import me.liuwj.ktorm.schema.int
import me.liuwj.ktorm.schema.timestamp
import me.liuwj.ktorm.schema.varchar
import java.time.Instant


class WelcomeController : Controller() {
    fun index(call: HttpCall) {
        call.render("welcome")



        val devDum = call.make<DatabaseConfig>().connect("mysql")


        devDum {

            val max = Videos
                .asSequence()
                .aggregateColumns { max(it.cat_id) }

            println(max)


            /*for (i in arr3.indices){
                println("Mult 3 : ${arr3[i]}")
            }*/


            fun getVideos(catId: Int): Any? {
                val videos = Videos
                    .asSequence()
                    .filter { it.cat_id eq catId }
                    .sortedByDescending { it.created_at }
                    .take(4)
                    .mapColumns3 { Tuple3(it.title, it.description, it.video_key) }
                    .toList()

                return videos
            }

            val ytVideos = getVideos(2)
            println(ytVideos)
        }



    }

}

interface Video : Entity<Video> {
    companion object : Entity.Factory<Video>()

    val id: Long
    //var cat_id: Long
    var category: String
    var title: String
    var description: String
    var video_key: String
    var created_at: Instant?
}


object Videos : MigratingTable<Video>("videos") {
    val id by bigIncrements("id")
    val cat_id by int("cat_id")
    val category by varchar("category")
    val title by varchar("title")
    val description by varchar("description")
    val video_key by varchar("video_key")
    val created_at by timestamp("created_at")

}







