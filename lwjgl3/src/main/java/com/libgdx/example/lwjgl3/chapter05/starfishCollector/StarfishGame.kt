package com.libgdx.example.lwjgl3.chapter05.starfishCollector

import chapter05.starfishCollector.MenuScreen

class StarfishGame: BaseGame() {
    override fun create() {
        super.create()
        setActiveScreen(MenuScreen())
    }
}
