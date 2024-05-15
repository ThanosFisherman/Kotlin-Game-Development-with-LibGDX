package com.libgdx.example.lwjgl3.chapter10.rectangleDestroyer

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration


object Launcher {

    @JvmStatic
    fun main(args: Array<String>) {

        val config =
            Lwjgl3ApplicationConfiguration().apply {
                setWindowedMode(800, 600)
                setTitle("52 Card Pickup")
            }

        Lwjgl3Application(RectangleDestroyer(), config)
    }
}
