package com.dev4dum.site.entities

import dev.alpas.ozone.MigratingTable
import dev.alpas.ozone.bigIncrements
import me.liuwj.ktorm.dsl.*
import me.liuwj.ktorm.entity.*
import me.liuwj.ktorm.schema.int
import me.liuwj.ktorm.schema.timestamp
import me.liuwj.ktorm.schema.varchar
import java.time.Instant

interface Video : Entity<Video> {
    companion object : Entity.Factory<Video>()

    val id: Long
    var cat_id: Int
    var category: String
    var title: String
    var description: String
    var video_key: String
    var created_at: Instant?
}

object Videos : MigratingTable<Video>("videos") {
    val id by bigIncrements("id").bindTo { it.id }
    val cat_id by int("cat_id").bindTo { it.cat_id }
    val category by varchar("category").bindTo { it.category }
    val title by varchar("title").bindTo { it.title }
    val description by varchar("description").bindTo { it.description }
    val video_key by varchar("video_key").bindTo { it.video_key }
    val created_at by timestamp("created_at").bindTo { it.created_at }

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

    fun latestVideos(): List<Video> {
        return select()
            //.where { it.cat_id eq catId }
            .orderBy(created_at.desc())
            // .limit(0,4)
            .map { row -> createEntity((row)) }
    }
}









