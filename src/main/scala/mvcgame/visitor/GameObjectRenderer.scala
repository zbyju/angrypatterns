package mvcgame.visitor

import scalafx.scene.canvas.GraphicsContext
import mvcgame.nullObject.Maybe
import mvcgame.model.gameObjects.AbstractCannon
import mvcgame.model.gameObjects.AbstractMissile
import scalafx.scene.image.Image
import mvcgame.config.MvcGameConfig

class GameObjectRenderer() extends GameObjectVisitor {
  private var gc: Maybe[GraphicsContext] = Maybe.None

  def setGraphicsContext(gc: GraphicsContext): Unit = {
    this.gc = Maybe.Some(gc)
  }

  override def visitCannon(cannon: AbstractCannon): Unit = {
    this.gc(
      _.drawImage(
        new Image(MvcGameConfig.CANNON_IMAGE_RESOURCE),
        cannon.pos.dimX,
        cannon.pos.dimY
      )
    )
  }

  override def visitMissile(missile: AbstractMissile): Unit = {
    this.gc(
      _.drawImage(
        new Image(MvcGameConfig.MISSILE_IMAGE_RESOURCE),
        missile.pos.dimX,
        missile.pos.dimY
      )
    )
  }

}
