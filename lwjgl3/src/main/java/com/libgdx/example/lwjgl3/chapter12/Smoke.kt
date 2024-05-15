package chapter12

import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.actions.Actions
import com.libgdx.example.lwjgl3.chapter12.BaseActor

class Smoke(x: Float, y: Float, s: Stage) : BaseActor(x, y, s) {
    init {
        loadTexture("chapter12/smoke.png")
        addAction(Actions.fadeOut(.5f))
        addAction(Actions.after(Actions.removeActor()))
    }
}
