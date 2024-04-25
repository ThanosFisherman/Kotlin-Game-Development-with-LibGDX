package com.libgdx.example.lwjgl3.chapter01

import chapter01.HelloWorldImage
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application

object HelloLauncher {
    @JvmStatic
    fun main(args: Array<String>) {
        Lwjgl3Application(HelloWorldImage())
    }
}

