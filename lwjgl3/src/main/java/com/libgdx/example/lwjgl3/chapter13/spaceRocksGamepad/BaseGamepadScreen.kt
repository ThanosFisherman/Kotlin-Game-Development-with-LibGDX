package com.libgdx.example.lwjgl3.chapter13.spaceRocksGamepad

import chapter13.spaceRocksGamepad.BaseScreen
import com.badlogic.gdx.controllers.ControllerListener
import com.badlogic.gdx.controllers.Controller
import com.badlogic.gdx.controllers.Controllers


abstract class BaseGamepadScreen : BaseScreen(), ControllerListener {
    init {
        Controllers.clearListeners()
        Controllers.addListener(this)
    }

    // methods required by ControllerListener interface
    //  enable discrete input processing

    override fun connected(controller: Controller) {}

    override fun disconnected(controller: Controller) {}

    override fun axisMoved(controller: Controller, axisCode: Int, value: Float): Boolean {
        return false
    }

    override fun buttonDown(controller: Controller, buttonCode: Int): Boolean {
        return false
    }

    override fun buttonUp(controller: Controller, buttonCode: Int): Boolean {
        return false
    }
}
