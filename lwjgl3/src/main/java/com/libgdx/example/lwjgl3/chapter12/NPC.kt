package chapter12

import com.badlogic.gdx.scenes.scene2d.Stage
import com.libgdx.example.lwjgl3.chapter12.BaseActor

class NPC(x: Float, y: Float, s: Stage) : BaseActor(x, y, s) {
    // the text to be displayed
    var text: String = " "

    // used to determine if dialog box text is currently being displayed
    var viewing: Boolean = false

    // ID used for specific graphics and identifying NPCs with dynamic messages
    private var ID: String = ""

    fun setID(id: String) {
        ID = id
        when (ID) {
            "gatekeeper" -> loadTexture("chapter12/npc-1.png")
            "shopkeeper" -> loadTexture("chapter12/npc-2.png")
            else -> loadTexture("chapter12/npc-3.png") // default image
        }
    }

    fun getID(): String = ID
}
