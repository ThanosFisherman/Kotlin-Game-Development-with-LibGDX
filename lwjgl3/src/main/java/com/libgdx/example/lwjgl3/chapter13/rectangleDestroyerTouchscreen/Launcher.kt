package chapter13.rectangleDestroyerTouchscreen

import com.badlogic.gdx.backends.lwjgl.LwjglApplication

object Launcher {
    @JvmStatic
    fun main(args: Array<String>) {
        LwjglApplication(RectangleDestroyer(), "Rectangle Destroyer", 800, 800)
    }
}
