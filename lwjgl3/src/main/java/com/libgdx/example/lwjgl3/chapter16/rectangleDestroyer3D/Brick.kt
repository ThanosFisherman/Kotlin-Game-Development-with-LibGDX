package chapter16.rectangleDestroyer3D

import com.libgdx.example.lwjgl3.chapter16.rectangleDestroyer3D.Stage3D

class Brick(x: Float, y: Float, z: Float, s: Stage3D) : Box(x, y, z, s) {
    init {
        loadTexture("chapter16/rectangleDestroyer3D/brick-gray.png")
        setScale(1.15f, .5f, .5f)
        setBaseRectangle()
    }
}

