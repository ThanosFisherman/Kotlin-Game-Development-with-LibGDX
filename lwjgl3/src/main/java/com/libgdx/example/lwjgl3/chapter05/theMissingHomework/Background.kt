package chapter05.theMissingHomework

import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.graphics.g2d.Animation
import com.badlogic.gdx.graphics.g2d.TextureRegion

class Background(x: Float, y: Float, s: Stage) : BaseActor(x, y, s) {
    var hallway: Animation<TextureRegion>
    var classroom: Animation<TextureRegion>
    var scienceLab: Animation<TextureRegion>
    var library: Animation<TextureRegion>

    init {
        hallway = loadTexture("chapter05/theMissingHomework/bg-hallway.jpg")
        classroom = loadTexture("chapter05/theMissingHomework/bg-classroom.jpg")
        scienceLab = loadTexture("chapter05/theMissingHomework/bg-science-lab.jpg")
        library = loadTexture("chapter05/theMissingHomework/bg-library.jpg")
        setSize(800f, 600f)
    }
}
