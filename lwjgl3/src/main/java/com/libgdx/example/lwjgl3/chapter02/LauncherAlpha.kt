package com.libgdx.example.lwjgl3.chapter02

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration

fun main() {

    val config =
        Lwjgl3ApplicationConfiguration().apply {
            setWindowedMode(800, 600)
            setTitle("Starfish Collector")
        }

    Lwjgl3Application(StarfishCollectorAlpha(), config)
}


