package chapter12

import com.badlogic.gdx.scenes.scene2d.Stage
import com.libgdx.example.lwjgl3.chapter12.BaseActor

class Arrow(x: Float, y: Float, s: Stage) : BaseActor(x, y, s) {
    init {
        loadTexture("chapter12/arrow.png")
        setSpeed(400f)
    }

    override fun act(dt: Float) {
        super.act(dt)
        applyPhysics(dt)
    }
}
