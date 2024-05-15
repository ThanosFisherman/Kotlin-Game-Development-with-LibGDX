package chapter12

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.math.Interpolation
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.actions.Actions
import com.libgdx.example.lwjgl3.chapter12.BaseActor

class ScreenTransition(x: Float, y: Float, s: Stage): BaseActor(x, y, s) {
    init {
        loadTexture("chapter12/overlay.png")
        color = Color.BLACK
        width = Gdx.graphics.width.toFloat()
        height = Gdx.graphics.height.toFloat()
        addAction(
            Actions.sequence(
                Actions.delay(1f),
                Actions.moveBy(-800f, 0f, .75f, Interpolation.sine),
                Actions.removeActor()
            ))
    }
}
