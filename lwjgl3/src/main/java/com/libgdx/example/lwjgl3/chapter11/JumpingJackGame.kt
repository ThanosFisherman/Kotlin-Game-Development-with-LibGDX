package com.libgdx.example.lwjgl3.chapter11

import chapter11.BaseGame
import chapter11.MenuScreen

class JumpingJackGame : BaseGame() {
    override fun create() {
        super.create()
        setActiveScreen(MenuScreen())
    }
}
