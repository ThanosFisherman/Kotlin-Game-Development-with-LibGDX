package chapter12

import com.badlogic.gdx.scenes.scene2d.Stage
import com.libgdx.example.lwjgl3.chapter12.BaseActor

class Coin(x: Float, y: Float, s: Stage) : BaseActor(x, y, s) {
    init {
        loadTexture("chapter12/coin.png")
    }
}
