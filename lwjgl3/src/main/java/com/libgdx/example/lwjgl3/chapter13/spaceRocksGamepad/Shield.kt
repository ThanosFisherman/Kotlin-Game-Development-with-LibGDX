package chapter13.spaceRocksGamepad

import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.actions.Actions

class Shield(x: Float, y: Float, s: Stage) : BaseActor(x, y, s) {
    init {
        loadTexture("chapter13/spaceRocksGamepad/shields.png")
        setScale(Constants.scale, Constants.scale)

        var pulse = Actions.sequence(
            Actions.scaleTo(1.05f, 1.05f, 1f),
            Actions.scaleTo(.95f, .95f, 1f)
        )
        addAction(Actions.forever(pulse))
    }
}
