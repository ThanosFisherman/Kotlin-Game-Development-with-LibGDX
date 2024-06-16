package chapter13.starfishCollectorGamepad

import com.badlogic.gdx.scenes.scene2d.Stage

class Rock(x: Float, y: Float, s: Stage): BaseActor(x, y, s) {
    init {
        loadTexture("chapter13/starfishCollectorGamepad/rock.png")
        setBoundaryPolygon(8)
    }
}
