@file:JvmName("Lwjgl3Launcher")

package com.libgdx.example.lwjgl3

import com.badlogic.gdx.Game
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration

/** Launches the desktop (LWJGL3) application. */

object Main : Game() {

    @JvmStatic
    fun main(args: Array<String>) {
        // This handles macOS support and helps on Windows.
        if (StartupHelper.startNewJvmIfRequired())
            return
        Lwjgl3Application(Main, Lwjgl3ApplicationConfiguration().apply {
            setTitle("Kotlin-Game-Development-with-LibGDX")
            setWindowedMode(640, 480)
            setWindowIcon(*(arrayOf(128, 64, 32, 16).map { "libgdx$it.png" }.toTypedArray()))
        })
    }


    override fun create() {

    }
}

