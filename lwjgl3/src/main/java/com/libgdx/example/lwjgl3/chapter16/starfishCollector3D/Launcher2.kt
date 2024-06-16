package com.libgdx.example.lwjgl3.chapter16.starfishCollector3D

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration

object Launcher2 {

    @JvmStatic
    fun main(args: Array<String>) {

        val config =
            Lwjgl3ApplicationConfiguration().apply {
                setWindowedMode(800, 600)
                setTitle("Movement Demo")
            }

        Lwjgl3Application(MoveDemo(), config)
    }
}
