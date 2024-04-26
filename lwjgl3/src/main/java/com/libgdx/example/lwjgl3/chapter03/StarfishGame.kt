package com.libgdx.example.lwjgl3.chapter03

import chapter03.BaseGame
import chapter03.MenuScreen

class StarfishGame: BaseGame() {
    override fun create() {
        setActiveScreen(MenuScreen())
    }
}
