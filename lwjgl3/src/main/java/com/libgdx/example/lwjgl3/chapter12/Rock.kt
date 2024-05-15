package chapter12

import com.badlogic.gdx.scenes.scene2d.Stage

class Rock(x: Float, y: Float, s: Stage) : Solid(x, y, 32f, 32f, s) {
    init {
        loadTexture("chapter12/rock.png")
        setBoundaryPolygon(8)
    }
}
