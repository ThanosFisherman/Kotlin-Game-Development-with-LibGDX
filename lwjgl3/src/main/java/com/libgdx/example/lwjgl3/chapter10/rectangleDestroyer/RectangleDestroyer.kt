package com.libgdx.example.lwjgl3.chapter10.rectangleDestroyer

import chapter10.rectangleDestroyer.BaseGame
import chapter10.rectangleDestroyer.MenuScreen

class RectangleDestroyer : BaseGame() {
    override fun create() {
        super.create()
        setActiveScreen(MenuScreen())
    }
}
