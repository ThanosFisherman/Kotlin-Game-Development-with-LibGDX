package chapter06.spaceRocks

import com.badlogic.gdx.math.MathUtils
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.actions.Actions

class Rock(x: Float, y: Float, s: Stage, scale: Float, speed: Float) : BaseActor(x, y, s) {

    init {
        loadTexture("chapter06/spaceRocks/rock.png")
        setScale(scale)

        var random = MathUtils.random(speed)

        addAction(Actions.forever(Actions.rotateBy(30f + random, 1f)))

        setSpeed(50f + random)
        setSpeed(50f + random)
        setDeceleration(0f)

        setMotionAngle(MathUtils.random(360f))
    }

    override fun act(dt: Float) {
        super.act(dt)
        applyPhysics(dt)
        wrapAroundWorld()
    }
}
