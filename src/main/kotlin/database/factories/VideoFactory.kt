package com.dev4dum.site.database.factories

import dev.alpas.ozone.EntityFactory
import dev.alpas.ozone.faker
import com.dev4dum.site.entities.Video
import com.dev4dum.site.entities.Videos
import dev.alpas.hashing.Hasher
import java.time.Instant

internal class VideoFactory(private val hasher: Hasher) : EntityFactory<Video, Videos>() {
    override val table = Videos
    
    override fun entity(): Video {
        // https://alpas.dev/docs/ozone

        return Video {

            created_at = Instant.now()
        }
    }
}