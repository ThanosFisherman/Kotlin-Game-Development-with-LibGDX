package chapter16.starfishCollector3D

import com.badlogic.gdx.backends.lwjgl.LwjglApplication

object Launcher {
    @JvmStatic
    fun main(args: Array<String>) {
        val myGame = CubeDemo()
        LwjglApplication(myGame, "Cube Demo", 800, 600)
    }
}
