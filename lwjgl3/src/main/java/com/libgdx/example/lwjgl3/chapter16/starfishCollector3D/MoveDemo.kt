package com.libgdx.example.lwjgl3.chapter16.starfishCollector3D

import chapter16.starfishCollector3D.DemoScreen

class MoveDemo : BaseGame() {
    override fun create() {
        super.create()
        setActiveScreen(DemoScreen())
    }
}

