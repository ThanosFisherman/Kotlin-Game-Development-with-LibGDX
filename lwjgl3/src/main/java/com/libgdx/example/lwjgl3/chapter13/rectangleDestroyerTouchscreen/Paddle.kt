package chapter13.rectangleDestroyerTouchscreen

import com.badlogic.gdx.scenes.scene2d.Stage

class Paddle(x: Float, y: Float, s: Stage) : BaseActor(x, y, s) {
    init {
        loadTexture("chapter13/rectangleDestroyerTouchscreen/paddle.png")
    }
}
