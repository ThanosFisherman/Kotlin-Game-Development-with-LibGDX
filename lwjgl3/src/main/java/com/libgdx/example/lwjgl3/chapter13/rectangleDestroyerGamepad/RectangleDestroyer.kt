package com.libgdx.example.lwjgl3.chapter13.rectangleDestroyerGamepad

import chapter13.rectangleDestroyerGamepad.BaseGame
import chapter13.rectangleDestroyerGamepad.MenuScreen

class RectangleDestroyer : BaseGame() {
    override fun create() {
        super.create()
        setActiveScreen(MenuScreen())
    }
}
