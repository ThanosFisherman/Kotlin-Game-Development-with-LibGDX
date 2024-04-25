package com.libgdx.example.lwjgl3.chapter02

import chapter02.StarfishCollectorAlpha
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application

object LauncherAlpha {
    @JvmStatic
    fun main(args: Array<String>) {
        Lwjgl3Application(
            StarfishCollectorAlpha()
        )
    }
}
