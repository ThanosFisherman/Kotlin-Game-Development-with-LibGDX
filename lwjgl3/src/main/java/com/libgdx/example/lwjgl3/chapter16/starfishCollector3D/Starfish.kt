package com.libgdx.example.lwjgl3.chapter16.starfishCollector3D

import chapter16.starfishCollector3D.ObjModel
import chapter16.starfishCollector3D.Stage3D

class Starfish(x: Float, y: Float, z: Float, s: Stage3D) : ObjModel(x, y, z, s) {
    init {
        loadObjModel("chapter16/starfishCollector3D/star.obj")
        setScale(3f, 1f, 3f)
        setBasePolygon()
    }

    override fun act(dt: Float) {
        super.act(dt)
        turn(90 * dt)
    }
}
