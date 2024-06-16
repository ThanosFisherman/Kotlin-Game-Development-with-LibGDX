package com.libgdx.example.lwjgl3.chapter13.spaceRocksGamepad

import chapter13.spaceRocksGamepad.BaseGame
import chapter13.spaceRocksGamepad.MenuScreen

class SpaceGame : BaseGame() {
    override fun create() {
        super.create()
        setActiveScreen(MenuScreen())
    }
}
