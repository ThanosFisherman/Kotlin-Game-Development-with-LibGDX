package chapter04

import com.badlogic.gdx.scenes.scene2d.Stage

class Explosion (x: Float, y: Float, s: Stage) : BaseActor(x, y, s) {
    init {
        loadAnimationFromSheet("chapter04/explosion.png", 6, 6, .03f, false)
    }

    override fun act(dt: Float) {
        super.act(dt)

        if (isAnimationFinished())
            remove()
    }
}
