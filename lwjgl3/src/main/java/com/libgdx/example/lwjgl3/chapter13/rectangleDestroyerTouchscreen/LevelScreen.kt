package chapter13.rectangleDestroyerTouchscreen

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.audio.Music
import com.badlogic.gdx.audio.Sound
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.math.MathUtils
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.scenes.scene2d.Event
import com.badlogic.gdx.scenes.scene2d.ui.Button
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad.TouchpadStyle
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable

class LevelScreen : BaseTouchScreen() {
    private lateinit var paddle: Paddle
    private lateinit var ball: Ball
    private lateinit var solid: Solid

    private var score = 0
    private var balls = 3
    private var gameOver = false
    private lateinit var scoreLabel: Label
    private lateinit var ballsLabel: Label
    private lateinit var messageLabel: Label

    private lateinit var bounceSound: Sound
    private lateinit var brickBumpSound: Sound
    private lateinit var wallBumpSound: Sound
    private lateinit var itemAppearSound: Sound
    private lateinit var itemCollectSound: Sound
    private lateinit var gameOverSound: Sound
    private lateinit var gameWin: Sound
    private lateinit var ballLost: Sound

    private lateinit var backgroundMusic: Music

    private var paddleStop = false
    private var paddleTimer = 0f

    private lateinit var touchpad: Touchpad

    override fun initialize() {
        // background
        val background = BaseActor(0f, 0f, mainStage)
        background.loadTexture("chapter13/rectangleDestroyerTouchscreen/space.png")
        BaseActor.setWorldBounds(background)

        // paddle
        paddle = Paddle(320f, 32f, mainStage)

        // walls
        Wall(0f, 0f, mainStage, 20f, 600f) // left wall
        Wall(780f, 0f, mainStage, 20f, 600f) // right wall
        Wall(0f, 550f, mainStage, 800f, 50f) // top wall

        // bricks
        val tempBrick = Brick(0f, 0f, mainStage)
        val brickWidth = tempBrick.width
        val brickHeight = tempBrick.height
        tempBrick.remove()

        val totalRows = 10
        val totalCols = 10
        val marginX = (800 - totalCols * brickWidth) / 2
        val marginY = (600 - totalRows * brickHeight) -120

        for (rowNum in 0 until totalRows) {
            for (colNum in 0 until totalCols) {
                val x = marginX + brickWidth * colNum
                val y = marginY + brickHeight * rowNum
                Brick(x, y, mainStage)
            }
        }

        // ball
        ball = Ball(0f, 0f, mainStage)

        // solid
        solid = Solid(400f, 300f, mainStage)

        // game
        balls = 3
        scoreLabel = Label("Score: $score", BaseGame.labelStyle)
        ballsLabel = Label("Balls: $balls", BaseGame.labelStyle)
        messageLabel = Label("Click to start", BaseGame.labelStyle)
        messageLabel.color = Color.CYAN

        uiTable.pad(5f)
        uiTable.add(scoreLabel)
        uiTable.add().expandX()
        uiTable.add(ballsLabel)
        uiTable.row()
        uiTable.add(messageLabel).colspan(3).expandY()

        bounceSound = Gdx.audio.newSound((Gdx.files.internal(("chapter13/rectangleDestroyerTouchscreen/boing.wav"))))
        brickBumpSound = Gdx.audio.newSound((Gdx.files.internal(("chapter13/rectangleDestroyerTouchscreen/bump.wav"))))
        wallBumpSound = Gdx.audio.newSound((Gdx.files.internal(("chapter13/rectangleDestroyerTouchscreen/bump-low.wav"))))
        itemAppearSound = Gdx.audio.newSound((Gdx.files.internal(("chapter13/rectangleDestroyerTouchscreen/swoosh.wav"))))
        itemCollectSound = Gdx.audio.newSound((Gdx.files.internal(("chapter13/rectangleDestroyerTouchscreen/pop.wav"))))
        gameOverSound = Gdx.audio.newSound((Gdx.files.internal(("chapter13/rectangleDestroyerTouchscreen/382310__myfox14__game-over-arcade.wav"))))
        gameWin = Gdx.audio.newSound((Gdx.files.internal(("chapter13/rectangleDestroyerTouchscreen/391539__mativve__electro-win-sound.wav"))))
        ballLost = Gdx.audio.newSound((Gdx.files.internal(("chapter13/rectangleDestroyerTouchscreen/159408__noirenex__life-lost-game-over.wav"))))

        backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal(("chapter13/rectangleDestroyerTouchscreen/Rollin-at-5.mp3")))
        backgroundMusic.isLooping = true
        backgroundMusic.volume = .5f
        backgroundMusic.play()

        Gdx.graphics.setWindowedMode(800, 800)
        initializeControlArea()
        val controlBackground = BaseActor(0f, 0f, controlStage)
        controlBackground.loadTexture("chapter13/rectangleDestroyerTouchscreen/pixels.jpg")

        val touchStyle = TouchpadStyle()
        touchStyle.knob = TextureRegionDrawable(TextureRegion(Texture(Gdx.files.internal("chapter13/rectangleDestroyerTouchscreen/joystick-knob.png"))))
        touchStyle.background = TextureRegionDrawable(TextureRegion(Texture(Gdx.files.internal("chapter13/rectangleDestroyerTouchscreen/joystick-background.png"))))
        touchpad = Touchpad(5f, touchStyle)

        val buttonStyle = ButtonStyle()
        buttonStyle.up = TextureRegionDrawable(TextureRegion(Texture("chapter13/rectangleDestroyerTouchscreen/nes_button.png")))

        val releaseButton = Button(buttonStyle)
        releaseButton.addListener { e: Event ->
            if (isTouchDownEvent(e)) {
                if (ball.isPaused()) {
                    ball.setPaused(false)
                    messageLabel.isVisible = false
                }
            }
            false
        }

        controlTable.toFront()
        controlTable.pad(50f)
        controlTable.add().colspan(3).height(600f)
        controlTable.row()
        controlTable.add(touchpad)
        controlTable.add(releaseButton)
    }

    override fun update(dt: Float) {
        val direction = Vector2(touchpad.knobPercentX, touchpad.knobPercentY)
        val length = direction.len()
        if (length > 0) {
            val mouseX = direction.x * 400 + 350 // this was rushed, but it works...
            if (!paddleStop) paddle.x = mouseX - paddle.width / 2
        }
        paddle.boundToWorld()

        if ( ball.isPaused() ) {
            ball.x = paddle.x + paddle.width / 2 - ball.width / 2
            ball.y = paddle.y + paddle.height / 2 + ball.height / 2
        }

        for (wall: BaseActor in BaseActor.getList(mainStage, Wall::class.java.canonicalName)) {
            if (ball.overlaps(wall)) {
                ball.bounceOff((wall))
                wallBumpSound.play()
            }
        }

        for (brick: BaseActor in BaseActor.getList(mainStage, Brick::class.java.canonicalName)) {
            if (ball.overlaps(brick)) {
                ball.bounceOff(brick)
                val explosion = Explosion(brick.x, brick.y, mainStage)
                explosion.height = brick.height
                explosion.centerAtActor(brick)
                brick.remove()
                score += 100
                scoreLabel.setText(("Score: $score"))

                val spawnProbability = 10
                if (MathUtils.random(0, 100) < spawnProbability) {
                    val i = Item(0f, 0f, mainStage)
                    i.centerAtActor(brick)
                    itemAppearSound.play()
                }

                brickBumpSound.play()
            }
        }

        if (ball.overlaps(paddle)) {
            val ballCenterX = ball.x + ball.width / 2
            val paddlePercentHit = (ballCenterX - paddle.x) / paddle.width
            val bounceAngle = MathUtils.lerp(150f, 30f, paddlePercentHit)
            ball.setMotionAngle(bounceAngle)
            bounceSound.play()
        }

        if (BaseActor.count(mainStage, Brick::class.java.canonicalName) == 0 && !gameOver) {
            messageLabel.setText("You win!")
            messageLabel.color = Color.LIME
            messageLabel.isVisible = true
            gameWin.play()
            gameOver = true
        }

        if (ball.y < -50 && BaseActor.count(mainStage, Brick::class.java.canonicalName) > 0) {
            ball.remove()

            if (balls > 0) {
                balls -= 1
                ballsLabel.setText("Balls: $balls")
                ball = Ball(0f, 0f, mainStage)

                messageLabel.setText("Click to start")
                messageLabel.color = Color.CYAN
                messageLabel.isVisible = true
                ballLost.play()
            } else if(!gameOver){
                messageLabel.setText("Game Over")
                messageLabel.color = Color.RED
                messageLabel.isVisible = true
                gameOverSound.play()
                gameOver = true
            }
        }

        for (item: BaseActor in BaseActor.getList(mainStage, Item::class.java.canonicalName)) {
            if (paddle.overlaps(item)) {
                val realItem = item as Item

                when {
                    realItem.getType() == Item.Type.PADDLE_EXPAND -> paddle.width = paddle.width * 1.25f
                    realItem.getType() == Item.Type.PADDLE_SHRINK -> paddle.width = paddle.width * .8f
                    realItem.getType() == Item.Type.BALL_SPEED_UP -> ball.setSpeed(ball.getSpeed() * 1.5f)
                    realItem.getType() == Item.Type.BALL_SPEED_DOWN -> ball.setSpeed(ball.getSpeed() * .9f)
                    realItem.getType() == Item.Type.PADDLE_STOP -> paddleStop = true
                    realItem.getType() == Item.Type.BRICK_DESTROY -> destroyRandomBrick()
                    realItem.getType() == Item.Type.BALL_LARGE -> scaleBall(1.2f)
                    realItem.getType() == Item.Type.BALL_SMALL -> scaleBall(.8f)
                    realItem.getType() == Item.Type.BALL_EXTRA -> extraBall()
                    realItem.getType() == Item.Type.BONUS_POINTS -> bonusPoints()
                }

                paddle.setBoundaryRectangle()
                item.remove()
                itemCollectSound.play()
            }
        }

        if (paddleStop) {
            paddleTimer += dt
            if (paddleTimer > 1) {
                paddleStop = false
                paddleTimer = 0f
            }
        }

        for (solid: BaseActor in BaseActor.getList(mainStage, Solid::class.java.canonicalName)) {
            if (ball.overlaps(solid)) {
                ball.bounceOff(solid)
                brickBumpSound.play()

                val r = MathUtils.random()
                val g = MathUtils.random()
                val b = MathUtils.random()
                val randomColor = Color(r, g, b, 1f)
                solid.color = randomColor
            }
        }
    }

    private fun destroyRandomBrick() {
        val brickList = ArrayList<Brick>()
        for (brick: BaseActor in BaseActor.getList(mainStage, Brick::class.java.canonicalName)) {
            brickList.add(brick as Brick)
        }
        val randomBrickToDestroy = MathUtils.random(0, brickList.size-1)
        brickList[randomBrickToDestroy].remove()
    }

    private fun scaleBall(scale: Float) {
        ball.width *= scale
        ball.height *= scale
        ball.setBoundaryRectangle()
    }

    private fun extraBall() {
        balls += 1
        ballsLabel.setText("Balls: $balls")
    }

    private fun bonusPoints() {
        score += 1000
        scoreLabel.setText("Score: $score")
    }
}
