package com.libgdx.example.lwjgl3.chapter02

import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.scenes.scene2d.Stage

abstract class GameBeta : Game() {

    protected lateinit var mainStage: Stage

    override fun create() {
        mainStage = Stage()
        initialize()
    }

    abstract fun initialize ()

    override fun render () {
        val dt: Float = Gdx.graphics.deltaTime

        // act method
        mainStage.act(dt)

        // defined by user
        update(dt)

        // clear the screen
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        // draw the graphics
        mainStage.draw()
    }

    abstract fun update(dt: Float)
}
