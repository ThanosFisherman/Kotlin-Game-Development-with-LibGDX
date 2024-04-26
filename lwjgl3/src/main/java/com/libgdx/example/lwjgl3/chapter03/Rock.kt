package com.libgdx.example.lwjgl3.chapter03

import com.badlogic.gdx.scenes.scene2d.Stage
import com.libgdx.example.lwjgl3.chapter03.BaseActor

class Rock(x: Float, y: Float, s: Stage): BaseActor(x, y, s) {
    init {
        loadTexture("chapter03/rock.png")
        setBoundaryPolygon(8)
    }
}
