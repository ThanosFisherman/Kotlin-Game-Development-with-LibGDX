# Hello, World!
This chapter creates a simple "Hello, World!" example.

![image](https://user-images.githubusercontent.com/4059636/51062390-0d8d9a00-15f7-11e9-9c70-3adb52e18a26.png)

## Lightweight Java Game Application
Lightweight Java Game Application (LWJGL) simplifies game development by accessing desktop computer hardware resources. Sets up the window and manages the graphics and audio, keyboard and mouse input, and file access.

## Texture
A texture is an object that stores image-related data: the dimensions (width and height) of an image and the color of each pixel.

## Driver Class
A driver class is a class whose purpose is to drive the execution of another class, which often involves creating an instance of the class and calling one or more of its methods. Gives potential to create driver classes for multiple platforms.

## New imports
**import com.badlogic.gdx.Game** - An ApplicationListener that delegates to a Screen. This allows an application to easily have multiple screens.

**import com.badlogic.gdx.Gdx** - Environment class holding references to the Application, Graphics, Audio, Files and Input instances. The references are held in public static fields which allows static access to all subsystems. Do not use Graphics in a thread that is not the rendering thread.

**import com.badlogic.gdx.files.FileHandle** - Gives access to the filesystem. Represents a file or directory on the filesystem, classpath, Android SD card, or Android assets directory.

**import com.badlogic.gdx.graphics.GL20** - Interface wrapping all the methods of OpenGL ES 2.0

**import com.badlogic.gdx.g2d.SpriteBatch** - Draws batched quads using indices. Collects textures then send to be rendered.

**import com.badlogic.gdx.graphics.Texture** - A Texture wraps a standard OpenGL ES texture. A Texture must be disposed of when it is no longer used.

**com.badlogic.gdx.backends.lwjgl.LwjglApplication** - An OpenGL surface fullscreen or in a lightweight window.
