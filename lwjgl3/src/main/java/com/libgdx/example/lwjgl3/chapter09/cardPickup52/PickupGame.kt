package com.libgdx.example.lwjgl3.chapter09.cardPickup52

import chapter09.cardPickup52.BaseGame
import chapter09.cardPickup52.LevelScreen
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.audio.Music

class PickupGame : BaseGame() {
    private lateinit var backgroundMusic: Music

    override fun create() {
        super.create()

        backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("chapter09/cardPickup52/backgroundMusic.wav"))
        backgroundMusic.volume = .25f
        backgroundMusic.isLooping = true
        backgroundMusic.play()

        setActiveScreen(LevelScreen())
    }
}
