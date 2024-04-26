package chapter05.starfishCollector

import com.badlogic.gdx.scenes.scene2d.Stage

class Rock(x: Float, y: Float, s: Stage): BaseActor(x, y, s) {
    init {
        loadTexture("chapter05/starfishCollector/rock.png")
        setBoundaryPolygon(8)
    }
}
