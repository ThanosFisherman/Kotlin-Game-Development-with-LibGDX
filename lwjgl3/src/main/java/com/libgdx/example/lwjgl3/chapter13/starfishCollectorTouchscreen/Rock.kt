package chapter13.starfishCollectorTouchscreen

import com.badlogic.gdx.scenes.scene2d.Stage

class Rock(x: Float, y: Float, s: Stage): BaseActor(x, y, s) {
    init {
        loadTexture("chapter13/starfishCollectorTouchscreen/rock.png")
        setBoundaryPolygon(8)
    }
}
