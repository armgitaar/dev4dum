package com.dev4dum.site.entities

import dev.alpas.auth.BaseUser
import dev.alpas.auth.BaseUsersTable
import dev.alpas.ozone.*
import me.liuwj.ktorm.dsl.*
import me.liuwj.ktorm.entity.*
import me.liuwj.ktorm.schema.int
import me.liuwj.ktorm.schema.timestamp
import me.liuwj.ktorm.schema.varchar
import java.time.Instant

interface Video : OzoneEntity<Video> {
    companion object : Entity.Factory<Video>()

    val id: Long
    var cat_id: Int
    var title: String
    var description: String
    var video_key: String
    var created_at: Instant?

}

object Videos : OzoneTable<Video>("videos") {
    val id by bigIncrements()
    val cat_id by int("cat_id").bindTo { it.cat_id }
    val title by varchar("title").bindTo { it.title }
    val description by varchar("description").bindTo { it.description }
    val video_key by varchar("video_key").bindTo { it.video_key }
    val created_at by timestamp("created_at").bindTo { it.created_at }

}