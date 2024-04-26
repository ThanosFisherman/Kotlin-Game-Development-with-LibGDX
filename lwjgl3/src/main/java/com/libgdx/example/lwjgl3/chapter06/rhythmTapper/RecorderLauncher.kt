package com.libgdx.example.lwjgl3.chapter06.rhythmTapper

import chapter06.rhythmTapper.RecorderGame
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration


object RecorderLauncher {

    @JvmStatic
    fun main(args: Array<String>) {

        val config =
            Lwjgl3ApplicationConfiguration().apply {
                setWindowedMode(800, 600)
                setTitle("Recorder")
            }

        Lwjgl3Application(RecorderGame(), config)
    }
}
