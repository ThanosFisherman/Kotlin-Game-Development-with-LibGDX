package com.libgdx.example.lwjgl3.chapter09.crazyEights

import chapter09.crazyEights.BaseGame
import chapter09.crazyEights.LevelScreen
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.audio.Music

class CrazyEightsGame : BaseGame() {
    private lateinit var backgroundMusic: Music

    override fun create() {
        super.create()

        backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("chapter09/crazyEights/backgroundMusic.wav"))
        backgroundMusic.volume = .25f
        backgroundMusic.isLooping = true
        backgroundMusic.play()

        setActiveScreen(LevelScreen())
    }
}
