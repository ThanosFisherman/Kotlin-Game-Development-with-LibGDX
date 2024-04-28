package com.libgdx.example.lwjgl3.chapter02

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.libgdx.example.lwjgl3.chapter02.ActorBeta

class Turtle : ActorBeta() {

    override fun act(dt: Float) {
        super.act(dt)

        if(Gdx.input.isKeyPressed(Input.Keys.W))
            this.moveBy(0f, 1f)
        if(Gdx.input.isKeyPressed(Input.Keys.A))
            this.moveBy(-1f, 0f)
        if(Gdx.input.isKeyPressed(Input.Keys.S))
            this.moveBy(0f, -1f)
        if(Gdx.input.isKeyPressed(Input.Keys.D))
            this.moveBy(1f, 0f)
    }
}
