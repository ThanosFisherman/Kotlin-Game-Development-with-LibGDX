package chapter10.rectangleDestroyer

import com.badlogic.gdx.scenes.scene2d.Stage

class Explosion(x: Float, y: Float, s: Stage) : BaseActor(x, y, s) {
    init {
        loadAnimationFromSheet("chapter10/rectangleDestroyer/explosion-35-35.png", 7, 6, .01f, false)
    }

    override fun act(dt: Float) {
        super.act(dt)

        if (isAnimationFinished())
            remove()
    }
}
