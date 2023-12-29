package mvcgame.visitor

import scalafx.scene.canvas.GraphicsContext
import mvcgame.nullObject.Maybe
import mvcgame.model.gameObjects.AbstractCannon
import mvcgame.model.gameObjects.AbstractMissile
import scalafx.scene.image.Image
import mvcgame.config.MvcGameConfig
import mvcgame.bridge.GameGraphics

class GameObjectRenderer() extends GameObjectVisitor {
  private var gameGraphics: Maybe[GameGraphics] = Maybe.None

  def setGameGraphics(gameGraphics: GameGraphics): Unit = {
    this.gameGraphics = Maybe.Some(gameGraphics)
  }

  override def visitCannon(cannon: AbstractCannon): Unit = {
    this.gameGraphics(
      _.drawImage(
        MvcGameConfig.CANNON_IMAGE_RESOURCE,
        cannon.pos
      )
    )
  }

  override def visitMissile(missile: AbstractMissile): Unit = {
    this.gameGraphics(
      _.drawImage(
        MvcGameConfig.MISSILE_IMAGE_RESOURCE,
        missile.pos
      )
    )
  }

}
