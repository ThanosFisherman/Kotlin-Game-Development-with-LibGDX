package chapter14

import com.badlogic.gdx.graphics.g2d.Animation
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.scenes.scene2d.Stage

class HeroIcon(x: Float, y: Float, s: Stage) : BaseActor(x, y, s) {
    val dying: Animation<TextureRegion>
    val dead: Animation<TextureRegion>

    init {
        loadTexture("chapter14/hero-icon-healthy.png")
        dying = loadTexture("chapter14/hero-icon-dying.png")
        dead = loadTexture("chapter14/hero-icon-dead.png")
    }
}
