package com.libgdx.example.lwjgl3.chapter13.spaceRocksTouchscreen

import chapter13.spaceRocksTouchscreen.BaseGame
import chapter13.spaceRocksTouchscreen.MenuScreen

class SpaceGame : BaseGame() {
    override fun create() {
        super.create()
        setActiveScreen(MenuScreen())
    }
}
