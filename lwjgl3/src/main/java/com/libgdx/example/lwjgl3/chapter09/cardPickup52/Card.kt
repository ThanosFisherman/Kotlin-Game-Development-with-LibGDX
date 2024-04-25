package chapter09.cardPickup52

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.scenes.scene2d.Stage

class Card(x: Float, y: Float, s: Stage) : DragAndDropActor(x, y, s) {

    var rankValue: Int = 0
    var suitValue: Int = 0

    val rankName: String
        get() = rankNames[rankValue]

    val suitName: String
        get() = suitNames[suitValue]

    private val clickClickSound = Gdx.audio.newSound(Gdx.files.internal("assets/click-click.wav"))
    private val lowWhooshSound = Gdx.audio.newSound(Gdx.files.internal("assets/low-whoosh.wav"))
    private val whooshSound = Gdx.audio.newSound(Gdx.files.internal("assets/whoosh.wav"))
    private val tingSound = Gdx.audio.newSound(Gdx.files.internal("assets/ting.wav"))

    fun setRankSuitValues(r: Int, s: Int) {
        rankValue = r
        suitValue = s
        val imageFileName = "assets/card$suitName$rankName.png"
        loadTexture(imageFileName)
        setSize(80f, 100f)
        setBoundaryRectangle()
    }

    override fun onDragStart() {
        super.onDragStart()
        clickClickSound.play()
    }

    override fun onDrop() {
        if (hasDropTarget()) {
            val pile = dropTarget as Pile?
            val topCard = pile!!.getTopCard()

            if (this.rankValue == topCard.rankValue + 1 && this.suitValue == topCard.suitValue) {
                moveToActor(pile)
                pile.addCard(this)
                isDraggable = false
                tingSound.play(.05f)
            } else {
                // avoid blocking view of pile when incorrect.
                lowWhooshSound.play()
                moveToStart()
            }
        } else {
            whooshSound.play()
        }
    }

    override fun act(dt: Float) {
        super.act(dt)
        boundToWorld()
    }

    companion object {
        var rankNames = arrayOf("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K")
        var suitNames = arrayOf("Clubs", "Hearts", "Spades", "Diamonds")
    }
}
