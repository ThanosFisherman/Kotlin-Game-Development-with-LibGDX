package com.libgdx.example.lwjgl3.chapter16.starfishCollector3D

import chapter16.starfishCollector3D.LevelScreen

class StarfishCollector3DGame : BaseGame() {
    override fun create() {
        super.create()
        setActiveScreen(LevelScreen())
    }
}
