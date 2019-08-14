package chapter12

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.scenes.scene2d.Stage

class ShopBomb(x: Float, y: Float, s: Stage) : BaseActor(x, y, s) {
    init {
        loadTexture("assets/bomb-icon.png")
    }
}
