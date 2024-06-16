package com.libgdx.example.lwjgl3.chapter15.spaceRocksParticles

import chapter15.spaceRocksParticles.BaseGame
import chapter15.spaceRocksParticles.MenuScreen

class SpaceGame : BaseGame() {
    override fun create() {
        super.create()
        setActiveScreen(MenuScreen())
    }
}
