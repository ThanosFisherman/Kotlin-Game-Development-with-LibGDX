package com.libgdx.example.lwjgl3.chapter13.rectangleDestroyerTouchscreen

import chapter13.rectangleDestroyerTouchscreen.BaseGame
import chapter13.rectangleDestroyerTouchscreen.MenuScreen

class RectangleDestroyer : BaseGame() {
    override fun create() {
        super.create()
        setActiveScreen(MenuScreen())
    }
}
