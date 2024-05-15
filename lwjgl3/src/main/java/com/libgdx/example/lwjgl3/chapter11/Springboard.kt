package chapter11

import com.badlogic.gdx.scenes.scene2d.Stage

class Springboard(x: Float, y: Float, s: Stage) : BaseActor(x, y, s) {
    init {
        loadAnimationFromSheet(
            "chapter11/items/springboard.png",
            1,
            3,
            .2f,
            true
        )
    }
}
