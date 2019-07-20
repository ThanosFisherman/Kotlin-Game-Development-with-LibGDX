package chapter9.jigsawPuzzle

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.audio.Music

class JigsawPuzzleGame : BaseGame() {
    private lateinit var backgroundMusic: Music

    override fun create() {
        super.create()

        backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("assets/backgroundMusic.wav"))
        backgroundMusic.volume = .25f
        backgroundMusic.isLooping = true
        backgroundMusic.play()

        setActiveScreen(LevelScreen())
    }
}
