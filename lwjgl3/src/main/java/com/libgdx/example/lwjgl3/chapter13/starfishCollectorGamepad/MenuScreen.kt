package chapter13.starfishCollectorGamepad

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input.Keys
import com.badlogic.gdx.audio.Music
import com.badlogic.gdx.scenes.scene2d.Event
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.InputEvent.Type
import com.badlogic.gdx.scenes.scene2d.ui.TextButton

class MenuScreen: BaseScreen() {
    private lateinit var backgroundMusic: Music

    override fun initialize() {
        val ocean = BaseActor(0f, 0f, mainStage)
        ocean.loadTexture("chapter13/starfishCollectorGamepad/water.jpg")
        ocean.setSize(800f, 600f)

        val title = BaseActor(0f, 0f, mainStage)
        title.loadTexture("chapter13/starfishCollectorGamepad/starfish-collector.png")
        /*title.centerAtPosition(400f, 300f)
        title.moveBy(0f, 100f)*/

        /*var start = BaseActor(0f, 0f, mainStage)
        start.loadTexture("chapter13/starfishCollectorGamepad/message-start.png")
        start.centerAtPosition(400f, 300f)
        start.moveBy(0f, -100f)*/

        val startButton = TextButton("Start", BaseGame.textButtonStyle)
        /*startButton.setPosition(150f, 150f)
        uiStage.addActor(startButton)*/
        startButton.addListener { e: Event ->
            val ie = e as InputEvent
            if (ie.type == Type.touchDown) {
                dispose()
                BaseGame.setActiveScreen(StoryScreen())
            }
            false
        }

        val quitButton = TextButton("Quit", BaseGame.textButtonStyle)
        /*quitButton.setPosition(500f, 150f)
        uiStage.addActor(quitButton)*/
        quitButton.addListener { e: Event ->
            val ie = e as InputEvent
            if (ie.type == Type.touchDown) {
                dispose()
                Gdx.app.exit()
            }
            false
        }

        uiTable.add(title).colspan(2)
        uiTable.row()
        uiTable.add(startButton)
        uiTable.add(quitButton)

        backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("chapter13/starfishCollectorGamepad/fantasy-orchestra.wav"))
        backgroundMusic.isLooping = true
        backgroundMusic.play()
    }

    override fun keyDown(keyCode: Int) : Boolean {
        if (Gdx.input.isKeyPressed(Keys.ENTER)) {
            dispose()
            BaseGame.setActiveScreen(StoryScreen())
        }
        if (Gdx.input.isKeyPressed(Keys.ESCAPE)) {
            dispose()
            Gdx.app.exit()
        }
        return false
    }

    override fun update(dt: Float) {
        /*if (Gdx.input.isKeyPressed(Keys.S)) {
            BaseGame.setActiveScreen(StoryScreen())
        }*/
    }

    override fun dispose() {
        super.dispose()
        backgroundMusic.dispose()
    }
}
