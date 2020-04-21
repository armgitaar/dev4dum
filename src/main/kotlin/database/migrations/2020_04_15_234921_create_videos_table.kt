package com.dev4dum.site.database.migrations

import com.dev4dum.site.entities.Videos
import dev.alpas.ozone.migration.Migration

class CreateVideosTable : Migration() {
    override var name = "2020_04_15_234921_create_videos_table"
    
    override fun up() {
        createTable(Videos)
    }
    
    override fun down() {
        dropTable(Videos)
    }
}