package chapter16.project3D

import chapter16.starfishCollector3D.MoveDemo
import com.badlogic.gdx.backends.lwjgl.LwjglApplication

object Launcher2 {
    @JvmStatic
    fun main(args: Array<String>) {
        val myGame = MoveDemo()
        LwjglApplication(myGame, "Movement Demo", 800, 600)
    }
}
