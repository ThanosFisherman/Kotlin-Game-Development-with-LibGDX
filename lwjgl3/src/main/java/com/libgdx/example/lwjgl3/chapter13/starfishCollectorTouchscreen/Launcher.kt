package com.libgdx.example.lwjgl3.chapter13.starfishCollectorTouchscreen

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration
import com.libgdx.example.lwjgl3.chapter02.StarfishCollectorBeta


object Launcher {

    @JvmStatic
    fun main(args: Array<String>) {

        val config =
            Lwjgl3ApplicationConfiguration().apply {
                setWindowedMode(800, 600)
                setTitle("StarfishCollector")
            }

        Lwjgl3Application(StarfishGame(), config)
    }
}
