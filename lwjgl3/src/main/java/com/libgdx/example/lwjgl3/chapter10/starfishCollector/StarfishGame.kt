package com.libgdx.example.lwjgl3.chapter10.starfishCollector

import chapter10.starfishCollector.BaseGame
import chapter10.starfishCollector.MenuScreen

class StarfishGame: BaseGame() {
    override fun create() {
        super.create()
        setActiveScreen(MenuScreen())
    }
}
