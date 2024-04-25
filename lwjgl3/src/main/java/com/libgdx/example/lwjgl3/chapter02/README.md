# Simple Starfish Collector
This chapter lays the groundwork of the object-oriented programming used throughout the rest of the book. This is perhaps the most important chapter in the whole book.

Added sharky as suggested in summary, sharky moves in random directions in random time intervals all whilst keeping inside the game window.

![image](https://user-images.githubusercontent.com/4059636/51061964-68be8d00-15f5-11e9-9fef-f42eea4ac9fd.png)


## The Life Cycle of a Video Game
* **Startup**: Any files needed are loaded, game objects are created, and values are initialized.
* **The game loop**: Repeats continuously while the game is running.
    * **Process Input**: Checks user action.
    * **Update**: Perform tasks that involve the state of the game world and entities
    * **Render**: Draw all graphics on the screen.
* **Shutdown**: Removing images or data from memory, saving player data or the game state, signaling the computer to stop monitoring hardware devices for user input, and closing any windows that were created by the game.

![untitled diagram](https://user-images.githubusercontent.com/4059636/53964770-38c0d100-40f0-11e9-8d25-e6e0f1d7319d.png)

A stage must receive input events so it can distribute them to actors. This is typically done by passing the stage to Gdx.input.setInputProcessor.

## Interfaces
An interface is a kind of contract that classes promise to do.
The methods are only declared; they do not contain any actual code. All that is required is the signature of the method: the name, the input, the output and any modifiers, such as public.
When implementing an interface you must write methods for everything declared in the interface.

## Abstract Classes
When programming you would want to reduce redundant code by refactoring repeated features in a base class and then extending that class. An abstract class is like an interface but the methods may also be written. 

## Diagram of the game's inheritance
![inheritance diagram](https://user-images.githubusercontent.com/4059636/54016944-d1a12c00-4184-11e9-8e6f-c7d2e3239c26.png)

## Game Paradigm
There are many ways to put together a LibGDX game. Below is a short description
of the main ideas that this project implements.

### GameBeta
The GameBeta.kt class is an extension of LibGDX's [game class](https://libgdx.badlogicgames.com/ci/nightlies/docs/api/com/badlogic/gdx/Game.html).
It encapsulates the addition of a Stage(), game assets initialization,
update & draw order and clearing the screen.

The paradigm is that the game must/will use a stage with actors.
When the main game class is created it can now only focus on what it should, namely
initializing resources and offering other game conditioning.

### ActorBeta
Extends LibGDX's [actor class](https://libgdx.badlogicgames.com/ci/nightlies/docs/api/com/badlogic/gdx/scenes/scene2d/Actor.html) to include graphics and collision detection.
Actor class now stores data such as position and rotation.

The downside with this implementation is that not every actor is an entity, and thus
does not need collision detection.

The advantage is that details such as graphics, collision detection, updating and drawing
is now encapsulated and everything is in one place.


## New Imports
**import com.badlogic.gdx.ApplicationListener** - An ApplicationListener is called when the Application is created, resumed, rendering, paused or destroyed. All methods are called in a thread that has the OpenGL context current. You can thus safely create and manipulate graphics resources.

The ApplicationListener interface follows the standard Android activity life-cycle and is emulated on the desktop accordingly.

**import com.badlogic.gdx.Input.Keys** - Input polling of keyboard states

**import com.badlogic.gdx.math.Rectangle** - Encapsulates a 2D rectangle defined by its corner point in the bottom left and its extents in x (width) and y (height).

**import com.badlogic.gdx.scenes.scene2d.Actor** - An actor has a position, rectangular size, origin, scale, rotation, Z index, and color. The position corresponds to the unrotated, unscaled bottom left corner of the actor. The position is relative to the actor's parent. The origin is relative to the position and is used for scale and rotation.

An actor has a list of in-progress actions that are applied to the actor (often over time). These are generally used to change the presentation of the actor (moving it, resizing it, etc). See act(float), Action, and its many subclasses.

**import com.badlogic.gdx.scenes.scene2d.Stage** - A 2D scene graph containing hierarchies of actors. Stage handles the viewport and distributes input events.
