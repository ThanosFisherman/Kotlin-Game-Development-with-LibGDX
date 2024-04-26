package chapter03

import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.utils.Array
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input.Keys
import com.libgdx.example.lwjgl3.chapter03.BaseActor

class Turtle(x: Float, y: Float, s: Stage) : BaseActor(x, y, s) {
    init {
        val fileNames: Array<String> = Array()
        fileNames.add("chapter03/turtle-1.png")
        fileNames.add("chapter03/turtle-2.png")
        fileNames.add("chapter03/turtle-3.png")
        fileNames.add("chapter03/turtle-4.png")
        fileNames.add("chapter03/turtle-5.png")
        fileNames.add("chapter03/turtle-6.png")
        loadAnimationFromFiles(fileNames, .1f, true)

        setBoundaryPolygon(8)

        setAcceleration(400f) // time to reach max speed = 100/400 = .25 seconds
        setMaxSpeed(100f) // pixels/seconds
        setDeceleration(400f) // time to reach zero speed = 100/400 = .25 seconds
    }

    override fun act(dt: Float) {
        super.act(dt)

        if (Gdx.input.isKeyPressed(Keys.W))
            accelerateAtAngle(90f)
        if (Gdx.input.isKeyPressed(Keys.A))
            accelerateAtAngle(180f)
        if (Gdx.input.isKeyPressed(Keys.S))
            accelerateAtAngle(270f)
        if (Gdx.input.isKeyPressed(Keys.D))
            accelerateAtAngle(0f)

        applyPhysics(dt)

        setAnimationPaused(!isMoving())

        if (getSpeed() > 0)
            rotation = getMotionAngle()

        boundToWorld()
        alignCamera()
    }
}
