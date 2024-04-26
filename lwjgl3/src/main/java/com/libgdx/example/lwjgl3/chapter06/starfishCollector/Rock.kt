package chapter06.starfishCollector

import com.badlogic.gdx.scenes.scene2d.Stage

class Rock(x: Float, y: Float, s: Stage): BaseActor(x, y, s) {
    init {
        loadTexture("chapter06/starfishCollector/rock.png")
        setBoundaryPolygon(8)
    }
}
