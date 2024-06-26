package chapter15.starfishCollectorShaders

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input.Keys
import com.badlogic.gdx.audio.Music
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.scenes.scene2d.actions.Actions

class StoryScreen: BaseScreen() {
    lateinit var scene: Scene
    lateinit var continueKey: BaseActor
    private lateinit var backgroundMusic: Music

    private lateinit var background: VignetteBackground

    override fun initialize() {
        background = VignetteBackground(0f, 0f, "chapter15/starfishCollectorShaders/oceanside.png", mainStage)
        background.setSize(800f, 600f)
        background.setOpacity(0f)
        BaseActor.setWorldBounds(background)

        val turtle = BaseActor(0f, 0f, mainStage)
        turtle.loadTexture("chapter15/starfishCollectorShaders/turtle-big.png")
        turtle.setPosition(-turtle.width, 0f)

        val dialogBox = DialogBox(0f, 0f, uiStage)
        dialogBox.setDialogSize(600f, 200f)
        dialogBox.setBackgroundColor(Color(.6f, .6f, .8f, 1f))
        dialogBox.setFontScale(.75f)
        dialogBox.isVisible = false

        uiTable.add(dialogBox).expandX().expandY().bottom()

        continueKey = BaseActor(0f, 0f, uiStage)
        continueKey.loadTexture("chapter15/starfishCollectorShaders/key-C.png")
        continueKey.setSize(32f, 32f)
        continueKey.isVisible = false

        dialogBox.addActor(continueKey)
        continueKey.setPosition(dialogBox.width - continueKey.width, 0f)

        backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("chapter15/starfishCollectorShaders/box-melody-1.mp3"))
        backgroundMusic.isLooping = true
        backgroundMusic.play()

        scene = Scene()
        mainStage.addActor(scene)

        scene.addSegment(SceneSegment(background, Actions.fadeIn(1f)))
        scene.addSegment(SceneSegment(turtle, SceneActions.moveToScreenCenter(2f)))
        scene.addSegment(SceneSegment(dialogBox, Actions.show()))

        scene.addSegment(SceneSegment(dialogBox, SceneActions.setText("I want to be the very best... Starfish Collector!")))

        scene.addSegment(SceneSegment(continueKey, Actions.show()))
        scene.addSegment(SceneSegment(background, SceneActions.pause()))
        scene.addSegment(SceneSegment(continueKey, Actions.hide()))

        scene.addSegment(SceneSegment(dialogBox, SceneActions.setText("I've got to collect them all!")))

        scene.addSegment(SceneSegment(continueKey, Actions.show()))
        scene.addSegment(SceneSegment(background, SceneActions.pause()))
        scene.addSegment(SceneSegment(continueKey, Actions.hide()))

        scene.addSegment(SceneSegment(dialogBox, Actions.hide()))
        scene.addSegment(SceneSegment(turtle, SceneActions.moveToOutsideRight(1f)))
        scene.addSegment(SceneSegment(background, Actions.fadeOut(1f)))

        scene.start()

        val transition = Transition(0f, 0f, "chapter15/starfishCollectorShaders/transition3.png", uiStage)
        transition.enabled = true
        transition.wayIn = false
    }

    override fun update(dt: Float) {
        if (scene.isSceneFinished) {
            val transition = Transition(0f, 0f, "chapter15/starfishCollectorShaders/transition3.png", uiStage)
            transition.enabled = true
            transition.wayIn = true
            background.addAction(
                Actions.sequence(
                    Actions.delay(transition.duration, Actions.run {
                        transition.remove()
                        dispose()
                        BaseGame.setActiveScreen(LevelScreen())
                    })
                )
            )

            /*dispose()
            BaseGame.setActiveScreen(LevelScreen())*/
        }
    }

    override fun keyDown(keyCode: Int): Boolean {
        if (keyCode == Keys.C && continueKey.isVisible)
            scene.loadNextSegment()

        return false
    }

    override fun dispose() {
        super.dispose()
        backgroundMusic.dispose()
    }
}
