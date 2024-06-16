package com.libgdx.example.lwjgl3.chapter13.starfishCollectorTouchscreen

import chapter13.starfishCollectorTouchscreen.BaseGame
import chapter13.starfishCollectorTouchscreen.MenuScreen

class StarfishGame: BaseGame() {
    override fun create() {
        super.create()
        setActiveScreen(MenuScreen())
    }
}
