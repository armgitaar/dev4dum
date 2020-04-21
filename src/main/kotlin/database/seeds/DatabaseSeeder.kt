package com.dev4dum.site.database.seeds

import com.dev4dum.site.database.factories.VideoFactory
import dev.alpas.Application
import dev.alpas.make
import dev.alpas.ozone.Seeder
import dev.alpas.ozone.from

internal class DatabaseSeeder : Seeder() {
    override fun run(app: Application) {

        val cat_id = 2..6
        val title: List<String> = listOf("Checking out SourceTree", "Checking out Exploding Topics", "1/3 Freeing up space on my Mac",
        "Welcome to Dev4Dum", "Creating a web app - Episode 5", "Creating dev4dum.com - Ep 26", "Creating dev4dum.com - Ep 15")
        val description: List<String> = listOf("Browsing Alpas' fireplace example app", "Add GA tracking code snippet", "Centering the logo",
            "Working on responsiveness", "Still trying to query db the way i want", "Pay attention to IntelliJ recommendations",
            "Got videos to dynamically list", "Setting up the database", "More db, didn't get far...")
        val video_key: List<String> = listOf("X1J8ouka380", "PRv9PbePGks", "492awCvMdY4", "rSf4y5ca7Uw", "x5FpMFiJXZI", "Tq-Ul4Y0voo", "3K0yqZsiozs", "tDkyjYbM0qg")

        var count = 0

        from(VideoFactory(app.make()), 20) {

            it.cat_id to cat_id.random()
            it.title to title.random()
            it.description to description.random()
            it.video_key to video_key.random()

            count++
        }

    }
}
