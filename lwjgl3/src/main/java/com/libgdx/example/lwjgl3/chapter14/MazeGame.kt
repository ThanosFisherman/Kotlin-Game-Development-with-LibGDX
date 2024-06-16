package com.libgdx.example.lwjgl3.chapter14

import chapter14.BaseGame
import chapter14.MenuScreen

class MazeGame : BaseGame() {
    override fun create() {
        super.create()
        setActiveScreen(MenuScreen())
    }
}
