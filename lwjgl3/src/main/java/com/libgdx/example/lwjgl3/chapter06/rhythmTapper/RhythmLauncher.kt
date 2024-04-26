package com.libgdx.example.lwjgl3.chapter06.rhythmTapper

import chapter06.rhythmTapper.RhythmGame
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration


object RhythmLauncher {

    @JvmStatic
    fun main(args: Array<String>) {

        val config =
            Lwjgl3ApplicationConfiguration().apply {
                setWindowedMode(800, 600)
                setTitle("RhythmGame")
            }

        Lwjgl3Application(RhythmGame(), config)
    }
}
