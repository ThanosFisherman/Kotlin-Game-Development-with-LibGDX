package chapter10.rectangleDestroyer

import com.badlogic.gdx.scenes.scene2d.Stage

class Brick(x: Float, y: Float, s: Stage) : BaseActor(x, y, s) {
    init {
        loadTexture("chapter10/rectangleDestroyer/brick-gray.png")
    }

}
