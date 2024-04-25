package chapter14

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input.Keys
import com.badlogic.gdx.audio.Music
import com.badlogic.gdx.audio.Sound
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Animation
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.actions.Actions
import com.badlogic.gdx.utils.Array

class Hero(x: Float, y: Float, s: Stage) : BaseActor(x, y, s) {
    var north: Animation<TextureRegion>
    var south: Animation<TextureRegion>
    var east: Animation<TextureRegion>
    var west: Animation<TextureRegion>

    var hurtSound: Sound
    var walkInGrassMusic: Music

    var health = 2
    var invincible = false
    private var invincibleTimer = 0f

    init {
        val fileName = "assets/hero.png"
        val rows = 4
        val cols = 3
        val texture = Texture(Gdx.files.internal(fileName), true)
        val frameWidth = texture.width / cols
        val frameHeight = texture.height / rows
        val frameDuration = .2f

        val temp = TextureRegion.split(texture, frameWidth, frameHeight)

        val textureArray = Array<TextureRegion>()
        for (c in 0 until cols)
            textureArray.add(temp[0][c])
        south = Animation(frameDuration, textureArray, Animation.PlayMode.LOOP_PINGPONG)

        textureArray.clear()
        for (c in 0 until cols)
            textureArray.add(temp[1][c])
        west = Animation(frameDuration, textureArray, Animation.PlayMode.LOOP_PINGPONG)

        textureArray.clear()
        for (c in 0 until cols)
            textureArray.add(temp[2][c])
        east = Animation(frameDuration, textureArray, Animation.PlayMode.LOOP_PINGPONG)

        textureArray.clear()
        for (c in 0 until cols)
            textureArray.add(temp[3][c])
        north = Animation(frameDuration, textureArray, Animation.PlayMode.LOOP_PINGPONG)

        setAnimation(south)

        // set after animation established
        setBoundaryPolygon(8)

        setAcceleration(800f)
        setMaxSpeed(100f)
        setDeceleration(800f)

        hurtSound = Gdx.audio.newSound(Gdx.files.internal("assets/hitHurt.wav"))
        walkInGrassMusic = Gdx.audio.newMusic(Gdx.files.internal("assets/walkGrass.wav"))

        zoomCamera(.9f)
    }

    override fun act(dt: Float) {
        super.act(dt)

        // hero movement controls
        if (Gdx.input.isKeyPressed(Keys.LEFT)) {
            accelerateAtAngle(180f)
            playConsecutiveAudio(walkInGrassMusic)
        }
        if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
            accelerateAtAngle(0f)
            playConsecutiveAudio(walkInGrassMusic)
        }
        if (Gdx.input.isKeyPressed(Keys.UP)) {
            accelerateAtAngle(90f)
            playConsecutiveAudio(walkInGrassMusic)
        }
        if (Gdx.input.isKeyPressed(Keys.DOWN)) {
            accelerateAtAngle(270f)
            playConsecutiveAudio(walkInGrassMusic)
        }

        // pause animation when character not moving
        if (getSpeed() == 0f)
            setAnimationPaused(true)
        else {
            setAnimationPaused(false)
            // set direction animation
            val angle = getMotionAngle()
            if (angle >= 45 && angle <= 135)
                setAnimation(north)
            else if (angle > 135 && angle < 225)
                setAnimation(west)
            else if (angle >= 225 && angle <= 315)
                setAnimation(south)
            else
                setAnimation(east)
        }
        applyPhysics(dt)


        if (invincible && invincibleTimer < 1.5f) {
            invincibleTimer += dt
        } else {
            invincibleTimer = 0f
            invincible = false
        }

        boundToWorld()
        alignCamera(lerp = .1f)
    }

    fun hit(): Int {
        if (!invincible) {
            if (health > 1) {
                hurtSound.play()
                addAction(
                    Actions.sequence(
                        Actions.color(Color.RED, .125f),
                        Actions.color(Color.WHITE, .125f),
                        Actions.color(Color.RED, .125f),
                        Actions.color(Color.WHITE, .125f),
                        Actions.color(Color.RED, .125f),
                        Actions.color(Color.WHITE, .125f)
                    )
                )
            }
            health--
            invincible = true
        }
        return health
    }

    private fun playConsecutiveAudio(music: Music) {
        if (!music.isPlaying) // only music have an isPlaying method
            music.play()
    }
}
