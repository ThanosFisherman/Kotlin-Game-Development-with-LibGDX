package chapter09.crazyEights

import com.badlogic.gdx.math.Interpolation
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.actions.Actions

class ScreenTransition(x: Float, y: Float, s: Stage): BaseActor(x, y, s) {
    init {
        loadTexture("chapter09/crazyEights/overlay.png")
        width = 800f
        height = 600f
        addAction(
            Actions.sequence(
                Actions.delay(1f),
                Actions.moveBy(-800f, 0f, .75f, Interpolation.sine),
                Actions.removeActor()
            ))
    }
}
