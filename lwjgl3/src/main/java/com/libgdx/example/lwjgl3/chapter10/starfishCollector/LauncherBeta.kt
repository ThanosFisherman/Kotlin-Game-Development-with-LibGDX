package com.libgdx.example.lwjgl3.chapter10.starfishCollector

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration


object LauncherBeta {

    @JvmStatic
    fun main(args: Array<String>) {

        val config =
            Lwjgl3ApplicationConfiguration().apply {
                setWindowedMode(800, 600)
                setTitle("StarfishCollector")
            }

        Lwjgl3Application(StarfishCollector(), config)
    }
}
