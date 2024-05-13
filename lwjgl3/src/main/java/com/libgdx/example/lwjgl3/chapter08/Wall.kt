package chapter08

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.scenes.scene2d.Stage

class Wall(x: Float, y: Float, s: Stage, width: Float, height: Float) : BaseActor(x, y, s) {
    init {
        loadTexture("chapter08/white-square.png")
        setSize(width, height)
        color = Color.GRAY
        setBoundaryRectangle()
    }
}
