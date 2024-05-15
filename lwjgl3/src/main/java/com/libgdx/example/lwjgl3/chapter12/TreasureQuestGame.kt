package com.libgdx.example.lwjgl3.chapter12

import chapter12.BaseGame
import chapter12.MenuScreen

class TreasureQuestGame : BaseGame() {
    override fun create() {
        super.create();
        setActiveScreen(MenuScreen())
    }
}
