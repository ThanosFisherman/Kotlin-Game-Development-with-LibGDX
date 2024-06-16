package com.libgdx.example.lwjgl3.chapter16.rectangleDestroyer3D

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration


object Launcher {

    @JvmStatic
    fun main(args: Array<String>) {

        val config =
            Lwjgl3ApplicationConfiguration().apply {
                setWindowedMode(800, 600)
                setTitle("StarfishGame")
            }

        Lwjgl3Application(RectangleDestroyer3D(), config)
    }
}
