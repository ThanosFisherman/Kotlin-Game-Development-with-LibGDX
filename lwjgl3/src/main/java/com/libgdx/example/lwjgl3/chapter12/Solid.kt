package chapter12

import com.badlogic.gdx.scenes.scene2d.Stage
import com.libgdx.example.lwjgl3.chapter12.BaseActor

open class Solid(x: Float, y: Float, width: Float, height: Float, s: Stage) : BaseActor(x, y, s) {
    init {
        setSize(width, height)
        setBoundaryRectangle()
    }
}
