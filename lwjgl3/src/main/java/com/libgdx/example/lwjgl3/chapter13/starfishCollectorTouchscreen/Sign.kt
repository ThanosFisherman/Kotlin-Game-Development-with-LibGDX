package chapter13.starfishCollectorTouchscreen

import com.badlogic.gdx.scenes.scene2d.Stage

class Sign(x: Float, y: Float, s: Stage) : BaseActor(x, y, s) {
    private var text: String // the text to be displayed
    private var viewing: Boolean // used to determine if sign text is currently being displayed

    init {
        loadTexture("chapter13/starfishCollectorTouchscreen/sign.png")
        text = " "
        viewing = false
    }

    fun setText(t: String) { text = t }
    fun getText() = text
    fun setViewing(v: Boolean) { viewing = v }
    fun isViewing() = viewing
}
