package chapter15.spaceRocksParticles

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.audio.Music
import com.badlogic.gdx.audio.Sound
import com.badlogic.gdx.scenes.scene2d.actions.Actions

class MenuScreen : BaseScreen() {

    private lateinit var music: Music
    private lateinit var blip: Sound

    override fun initialize() {
        val space = BaseActor(0f, 0f, mainStage)
        space.loadTexture("chapter15/spaceRocksParticles/space.png")
        space.setSize(800f, 600f)

        val start = BaseActor(0f, 0f, mainStage)
        start.loadTexture("chapter15/spaceRocksParticles/message-start.png")
        start.centerAtPosition(400f, 300f)
        start.setOpacity(0f)
        start.addAction(Actions.fadeIn(1f))

        music = Gdx.audio.newMusic(Gdx.files.internal("chapter15/spaceRocksParticles/fantasy-orchestra.wav"))
        music.isLooping = true
        music.play()

        blip = Gdx.audio.newSound(Gdx.files.internal("chapter15/spaceRocksParticles/blip.wav"))
    }

    override fun update(dt: Float) {}

    // Override default InputProcessor method
    override fun keyDown(keycode: Int): Boolean {
        if (keycode == Input.Keys.S) {
            blip.play()
            dispose()
            BaseGame.setActiveScreen(LevelScreen())
        }
        return false
    }

    override fun dispose() {
        super.dispose()
        music.dispose()
        blip.dispose()
    }
}
