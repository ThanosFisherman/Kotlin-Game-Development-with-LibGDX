package chapter13.spaceRocksGamepad

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.audio.Music
import com.badlogic.gdx.audio.Sound
import com.badlogic.gdx.controllers.Controller
import com.badlogic.gdx.scenes.scene2d.actions.Actions
import com.libgdx.example.lwjgl3.chapter13.spaceRocksGamepad.BaseGamepadScreen
import com.libgdx.example.lwjgl3.chapter13.spaceRocksGamepad.XBoxGamepad

class MenuScreen : BaseGamepadScreen() {

    private lateinit var music: Music
    private lateinit var blip: Sound

    override fun initialize() {
        val space = BaseActor(0f, 0f, mainStage)
        space.loadTexture("chapter13/spaceRocksGamepad/space.png")
        space.setSize(800f, 600f)

        val start = BaseActor(0f, 0f, mainStage)
        start.loadTexture("chapter13/spaceRocksGamepad/message-start.png")
        start.centerAtPosition(400f, 300f)
        start.setOpacity(0f)
        start.addAction(Actions.fadeIn(1f))

        music = Gdx.audio.newMusic(Gdx.files.internal("chapter13/spaceRocksGamepad/fantasy-orchestra.wav"))
        music.isLooping = true
        music.play()

        blip = Gdx.audio.newSound(Gdx.files.internal("chapter13/spaceRocksGamepad/blip.wav"))
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

    override fun buttonDown(controller: Controller, buttonCode: Int): Boolean {
        if (buttonCode == XBoxGamepad.BUTTON_A) {
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
