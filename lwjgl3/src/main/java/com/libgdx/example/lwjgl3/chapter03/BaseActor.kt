package com.libgdx.example.lwjgl3.chapter03

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.Texture.TextureFilter
import com.badlogic.gdx.graphics.g2d.Animation
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.math.*
import com.badlogic.gdx.math.Intersector.MinimumTranslationVector
import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.utils.Array

/**
 *   Extend functionality of the LibGDX Actor class.
 */
open class BaseActor(x: Float, y: Float, s: Stage) : Actor() {

    private var animation: Animation<TextureRegion>? = null
    private var elapsedTime: Float = 0F
    private var animationPaused: Boolean = false

    private val velocityVec: Vector2 = Vector2(0f, 0f)
    private val accelerationVec: Vector2 = Vector2(0f, 0f)
    private var acceleration: Float = 0f
    private var maxSpeed: Float = 1000f
    private var deceleration: Float = 0f

    private var boundaryPolygon: Polygon? = null

    init {
        this.x = x
        this.y = y
        s.addActor(this)
    }

    override fun act(dt: Float) {
        super.act(dt)

        if (!animationPaused)
            elapsedTime += dt
    }

    override fun draw(batch: Batch, parentAlpha: Float) {
        super.draw(batch, parentAlpha)

        //  apply color tint effect
        val c: Color = color
        batch.setColor(c.r, c.g, c.b, c.a)

        if (animation != null && isVisible) {
            batch.draw(
                animation?.getKeyFrame(elapsedTime),
                x,
                y,
                originX,
                originY,
                width,
                height,
                scaleX,
                scaleY,
                rotation
            )
        }
    }

    // Graphics ---------------------------------------------------------------------------------------------------
    fun setAnimation(anim: Animation<TextureRegion>) {
        animation = anim
        val tr: TextureRegion = animation!!.getKeyFrame(0.toFloat())
        val w: Float = tr.regionWidth.toFloat()
        val h: Float = tr.regionHeight.toFloat()
        setSize(w, h)
        setOrigin(w / 2, h / 2)

        if (boundaryPolygon == null)
            setBoundaryRectangle()
    }

    fun setAnimationPaused(pause: Boolean) {
        animationPaused = pause
    }

    fun loadAnimationFromFiles(
        fileNames: Array<String>,
        frameDuration: Float,
        loop: Boolean,
        textureFilter: TextureFilter = TextureFilter.Linear
    ): Animation<TextureRegion> {
        val textureArray: Array<TextureRegion> = Array()

        for (i in 0..fileNames.size - 1) {
            val texture = Texture(Gdx.files.internal(fileNames[i]))
            texture.setFilter(textureFilter, textureFilter)
            textureArray.add(TextureRegion(texture))
        }

        val anim: Animation<TextureRegion> = Animation(frameDuration, textureArray)

        if (loop)
            anim.playMode = Animation.PlayMode.LOOP
        else
            anim.playMode = Animation.PlayMode.NORMAL

        if (animation == null)
            setAnimation(anim)

        return anim
    }

    fun loadAnimationFromSheet(
        fileName: String,
        rows: Int,
        cols: Int,
        frameDuration: Float,
        loop: Boolean,
        textureFilter: TextureFilter = TextureFilter.Linear
    ): Animation<TextureRegion> {
        val texture = Texture(Gdx.files.internal(fileName), true)
        texture.setFilter(textureFilter, textureFilter)
        val frameWidth: Int = texture.width / cols
        val frameHeight: Int = texture.height / rows

        val temp = TextureRegion.split(texture, frameWidth, frameHeight)
        val textureArray: Array<TextureRegion> = Array()

        for (r in 0 until rows) {
            for (c in 0 until cols) {
                textureArray.add(temp[r][c])
            }
        }

        val anim: Animation<TextureRegion> = Animation(frameDuration, textureArray)

        if (loop)
            anim.playMode = Animation.PlayMode.LOOP
        else
            anim.playMode = Animation.PlayMode.NORMAL

        if (animation == null)
            setAnimation(anim)

        return anim
    }

    fun loadTexture(fileName: String): Animation<TextureRegion> {
        val fileNames: Array<String> = Array(1)
        fileNames.add(fileName)
        return loadAnimationFromFiles(fileNames, 1.toFloat(), true)
    }

    fun isAnimationFinished(): Boolean {
        return animation!!.isAnimationFinished(elapsedTime)
    }

    // Physics ---------------------------------------------------------------------------------------------------
    fun setSpeed(speed: Float) {
        // If length is zero, then assume motion angle is zero degrees
        if (velocityVec.len() == 0f)
            velocityVec.set(speed, 0f)
        else
            velocityVec.setLength(speed)
    }

    fun getSpeed() = velocityVec.len()
    fun setMotionAngle(angle: Float): Vector2 = velocityVec.setAngle(angle)
    fun getMotionAngle() = velocityVec.angleDeg()
    fun isMoving() = getSpeed() > 0

    fun setAcceleration(acc: Float) {
        acceleration = acc
    }

    fun accelerateAtAngle(angle: Float): Vector2 = accelerationVec.add(Vector2(acceleration, 0f).setAngleDeg(angle))
    fun accelerateForward(): Vector2 = accelerateAtAngle(rotation)
    fun setMaxSpeed(ms: Float) {
        maxSpeed = ms
    }

    fun setDeceleration(dec: Float) {
        deceleration = dec
    }

    fun applyPhysics(dt: Float) {
        // apply acceleration
        velocityVec.add(accelerationVec.x * dt, accelerationVec.y * dt)

        var speed = getSpeed()

        // decrease speed (decelerate) when not accelerating
        if (accelerationVec.len() == 0f)
            speed -= deceleration * dt

        // keep speed within set bounds
        speed = MathUtils.clamp(speed, 0f, maxSpeed)

        // update velocity
        setSpeed(speed)

        // apply velocity
        moveBy(velocityVec.x * dt, velocityVec.y * dt)

        // reset acceleration
        accelerationVec.set(0f, 0f)
    }

    // Collision detection ------------------------------------------------------------------------------------------
    fun setBoundaryRectangle() {
        val w: Float = width
        val h: Float = height
        val vertices: FloatArray = floatArrayOf(0f, 0f, w, 0f, w, h, 0f, h)
        boundaryPolygon = Polygon(vertices)
    }

    fun setBoundaryPolygon(numSides: Int) {
        val w: Float = width
        val h: Float = height

        val vertices = FloatArray(2 * numSides)
        for (i in 0 until numSides) {
            val angle: Float = i * MathUtils.PI2 / numSides
            vertices[2 * i] = w / 2 * MathUtils.cos(angle) + w / 2    // x-coordinates
            vertices[2 * i + 1] = h / 2 * MathUtils.sin(angle) + h / 2  // y-coordinates
        }
        boundaryPolygon = Polygon(vertices)
    }

    fun getBoundaryPolygon(): Polygon {
        boundaryPolygon?.setPosition(x, y)
        boundaryPolygon?.setOrigin(originX, originY)
        boundaryPolygon?.rotation = rotation
        boundaryPolygon?.setScale(scaleX, scaleY)
        return boundaryPolygon as Polygon
    }

    fun overlaps(other: BaseActor): Boolean {
        val poly1: Polygon = this.getBoundaryPolygon()
        val poly2: Polygon = other.getBoundaryPolygon()

        // initial test to improve performance
        if (!poly1.boundingRectangle.overlaps(poly2.boundingRectangle))
            return false
        return Intersector.overlapConvexPolygons(poly1, poly2)
    }

    fun preventOverlap(other: BaseActor): Vector2? {
        val poly1: Polygon = this.getBoundaryPolygon()
        val poly2: Polygon = other.getBoundaryPolygon()

        // initial test to improve performance
        if (!poly1.boundingRectangle.overlaps(poly2.boundingRectangle))
            return null

        val mtv = MinimumTranslationVector()
        val polygonOverlap = Intersector.overlapConvexPolygons(poly1, poly2, mtv)

        if (!polygonOverlap)
            return null

        this.moveBy(mtv.normal.x * mtv.depth, mtv.normal.y * mtv.depth)
        return mtv.normal

    }

    // miscellaneous ------------------------------------------------------------------------------------------
    fun centerAtPosition(x: Float, y: Float) = setPosition(x - width / 2, y - height / 2)
    fun centerAtActor(other: BaseActor) = centerAtPosition(other.x + other.width / 2, other.y + other.height / 2)
    fun setOpacity(opacity: Float) {
        this.color.a = opacity
    }

    fun boundToWorld() {
        // check left edge
        if (x < 0)
            x = 0f
        // check right edge
        if (x + width > worldBounds.width)
            x = worldBounds.width - width
        // check bottom edge
        if (y < 0)
            y = 0f
        // check top edge
        if (y + height > worldBounds.height)
            y = worldBounds.height - height
    }

    fun alignCamera() {
        val camera = this.stage.camera
        val viewport = this.stage.viewport

        // center camera on actor
        camera.position.set(x + originX, y + originY, 0f)

        // bind camera to layout
        camera.position.x = MathUtils.clamp(
            camera.position.x,
            camera.viewportWidth / 2,
            worldBounds.width - camera.viewportWidth / 2
        )
        camera.position.y = MathUtils.clamp(
            camera.position.y,
            camera.viewportHeight / 2,
            worldBounds.height - camera.viewportHeight / 2
        )
        camera.update()
    }

    companion object {
        private lateinit var worldBounds: Rectangle

        fun setWorldBounds(width: Float, height: Float) {
            worldBounds = Rectangle(0f, 0f, width, height)
        }

        fun setWorldBounds(ba: BaseActor) = setWorldBounds(ba.width, ba.height)

        fun getList(stage: Stage, className: String): ArrayList<BaseActor> {
            var list: ArrayList<BaseActor> = ArrayList()

            var theClass: Class<*>? = null
            try {
                theClass = Class.forName(className)
            } catch (error: Exception) {
                error.printStackTrace()
            }

            for (actor in stage.actors) {
                if (theClass!!.isInstance(actor)) {
                    list.add(actor as BaseActor)
                }
            }
            return list
        }

        fun count(stage: Stage, className: String): Int {
            return getList(stage, className).size
        }
    }
}







