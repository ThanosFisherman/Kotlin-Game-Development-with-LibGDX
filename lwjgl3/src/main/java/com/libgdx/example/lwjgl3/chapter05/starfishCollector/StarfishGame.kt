package chapter05.starfishCollector

import com.libgdx.example.lwjgl3.chapter05.starfishCollector.BaseGame

class StarfishGame: BaseGame() {
    override fun create() {
        super.create()
        setActiveScreen(MenuScreen())
    }
}
