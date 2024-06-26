package chapter10.rectangleDestroyer

import com.badlogic.gdx.math.MathUtils
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.actions.Actions

class Item(x: Float, y: Float, s: Stage) : BaseActor(x, y, s) {
    enum class Type {
        PADDLE_EXPAND, PADDLE_SHRINK, BALL_SPEED_UP, BALL_SPEED_DOWN,
        PADDLE_STOP, BRICK_DESTROY, BALL_LARGE, BALL_SMALL, BALL_EXTRA,
        BONUS_POINTS
    };

    private lateinit var type: Type

    init {
        setRandomType()

        setSpeed(100f)
        setMotionAngle(270f)

        setSize(50f, 50f)
        setOrigin(25f, 25f)
        setBoundaryRectangle()

        setScale(0f, 0f)
        addAction(Actions.scaleTo(1f, 1f, .25f))
    }

    fun setType(t: Type) {
        type = t

        when (t) {
            Type.PADDLE_EXPAND -> loadTexture("chapter10/rectangleDestroyer/items/paddle-expand.png")
            Type.PADDLE_SHRINK -> loadTexture("chapter10/rectangleDestroyer/items/paddle-shrink.png")
            Type.BALL_SPEED_UP -> loadTexture("chapter10/rectangleDestroyer/items/ball-speed-up.png")
            Type.BALL_SPEED_DOWN -> loadTexture("chapter10/rectangleDestroyer/items/ball-speed-down.png")
            Type.PADDLE_STOP -> loadTexture("chapter10/rectangleDestroyer/items/paddle-stop.png")
            Type.BRICK_DESTROY -> loadTexture("chapter10/rectangleDestroyer/items/brick-destroy.png")
            Type.BALL_LARGE -> loadTexture("chapter10/rectangleDestroyer/items/ball-large.png")
            Type.BALL_SMALL -> loadTexture("chapter10/rectangleDestroyer/items/ball-small.png")
            Type.BALL_EXTRA -> loadTexture("chapter10/rectangleDestroyer/items/ball-extra.png")
            Type.BONUS_POINTS -> loadTexture("chapter10/rectangleDestroyer/items/bonus-points.png")
            else -> loadTexture("chapter10/rectangleDestroyer/items/item-blank.png")
        }
    }

    fun setRandomType() {
        val randomIndex = MathUtils.random(0, Type.values().size - 1)
        val randomType = Type.values()[randomIndex]
        setType(randomType)
    }

    fun getType():Type {return type }

    override fun act(dt: Float) {
        super.act(dt)
        applyPhysics(dt)

        if (y < -50) {
            remove()
        }
    }
}
