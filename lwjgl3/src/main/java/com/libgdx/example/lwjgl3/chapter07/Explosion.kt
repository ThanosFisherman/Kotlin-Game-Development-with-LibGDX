package chapter07

import com.badlogic.gdx.scenes.scene2d.Stage

class Explosion(x: Float, y: Float, s: Stage) : BaseActor(x, y, s) {
    init {
        loadAnimationFromSheet(
            "chapter07/explosion.png",
            6,
            6,
            .02f,
            false
        )
    }

    override fun act(dt: Float) {
        super.act(dt)
        if (isAnimationFinished())
            remove()
    }
}
