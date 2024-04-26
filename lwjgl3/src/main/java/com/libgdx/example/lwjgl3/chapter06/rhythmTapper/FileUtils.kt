package com.libgdx.example.lwjgl3.chapter06.rhythmTapper


import java.io.File
import com.badlogic.gdx.files.FileHandle
import javafx.application.Platform
import javafx.embed.swing.JFXPanel
import javafx.stage.FileChooser

object FileUtils {
    private var finished: Boolean = false
    private var fileHandle: FileHandle? = null
    private val openDialog = 1
    private val saveDialog = 2

    fun showOpenDialog(): FileHandle? {
        return showDialog(openDialog)
    }

    fun showSaveDialog(): FileHandle? {
        return showDialog(saveDialog)
    }

    private fun showDialog(dialogType: Int): FileHandle? {
        JFXPanel()

        finished = false

        Platform.runLater {
            val fileChooser = FileChooser()
            val file: File?

            if (dialogType == openDialog)
                file = fileChooser.showOpenDialog(null)
            else
            // dialogType == saveDialog
                file = fileChooser.showSaveDialog(null)

            if (file != null)
                fileHandle = FileHandle(file)
            else
                fileHandle = null

            finished = true
        }

        while (!finished) {
            // waits for FileChooser window to close
        }

        return fileHandle
    }
}
