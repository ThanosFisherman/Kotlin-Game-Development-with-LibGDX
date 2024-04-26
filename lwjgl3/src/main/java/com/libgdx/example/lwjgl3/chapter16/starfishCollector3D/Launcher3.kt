package com.libgdx.example.lwjgl3.chapter16.starfishCollector3D

import chapter16.starfishCollector3D.StarfishCollector3DGame
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration

object Launcher3 {

    @JvmStatic
    fun main(args: Array<String>) {

        val config =
            Lwjgl3ApplicationConfiguration().apply {
                setWindowedMode(800, 600)
                setTitle("Starfish Collector 3D")
            }

        Lwjgl3Application(StarfishCollector3DGame(), config)
    }
}
