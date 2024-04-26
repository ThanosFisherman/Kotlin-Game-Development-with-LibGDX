package com.libgdx.example.lwjgl3.chapter16.cubeDemo

import chapter16.project3D.demoCube
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration

object DemoCubeLauncher {

    @JvmStatic
    fun main(args: Array<String>) {

        val config =
            Lwjgl3ApplicationConfiguration().apply {
                setWindowedMode(800, 600)
                setTitle("Cube Demo")
            }

        Lwjgl3Application(demoCube(), config)
    }
}
