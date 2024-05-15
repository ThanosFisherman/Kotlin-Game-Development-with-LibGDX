package chapter10.starfishCollector

import com.badlogic.gdx.scenes.scene2d.Stage

class Rock(x: Float, y: Float, s: Stage): BaseActor(x, y, s) {
    init {
        loadTexture("chapter10/starfishCollector/rock.png")
        setBoundaryPolygon(8)
    }
}
