package com.libgdx.example.lwjgl3.chapter13.starfishCollectorGamepad

import chapter13.starfishCollectorGamepad.BaseGame
import chapter13.starfishCollectorGamepad.MenuScreen

class StarfishGame: BaseGame() {
    override fun create() {
        super.create()
        setActiveScreen(MenuScreen())
    }
}
