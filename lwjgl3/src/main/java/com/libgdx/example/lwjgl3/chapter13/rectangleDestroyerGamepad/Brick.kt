package chapter13.rectangleDestroyerGamepad

import com.badlogic.gdx.scenes.scene2d.Stage

class Brick(x: Float, y: Float, s: Stage) : BaseActor(x, y, s) {
    init {
        loadTexture("chapter13/rectangleDestroyerGamepad/brick-gray.png")
    }

}
