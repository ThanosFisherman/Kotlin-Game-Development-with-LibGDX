package com.libgdx.example.lwjgl3.chapter15.spaceRocksParticles

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration


object SpaceRocks {

    @JvmStatic
    fun main(args: Array<String>) {

        val config =
            Lwjgl3ApplicationConfiguration().apply {
                setWindowedMode(800, 600)
                setTitle("Space Rocks")
            }

        Lwjgl3Application(SpaceGame(), config)
    }
}
