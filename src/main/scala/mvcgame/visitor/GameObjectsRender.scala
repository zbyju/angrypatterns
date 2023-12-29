package mvcgame.visitor

import scalafx.scene.canvas.GraphicsContext
import mvcgame.nullObject.Maybe
import mvcgame.model.gameObjects.AbstractCannon
import mvcgame.model.gameObjects.AbstractMissile
import scalafx.scene.image.Image
import mvcgame.config.MvcGameConfig
import mvcgame.bridge.GameGraphical

class GameObjectsRender extends GameObjectVisitor {
  private var gr: Maybe[GraphicsContext] = Maybe.None
  private var gg: Maybe[GameGraphical] = Maybe.None

  def setGraphicsContext(gr: GraphicsContext): Unit = this.gr = Maybe.Some(gr)
  def setGraphicsContext(gg: GameGraphical): Unit = this.gg = Maybe.Some(gg)

  override def visitCannon(cannon: AbstractCannon): Unit = {
    this.gr(
      _.drawImage(
        new Image(MvcGameConfig.CANNON_IMAGE_RESOURCE),
        cannon.pos.dimX,
        cannon.pos.dimY
      )
    );
    this.gg(
      _.drawImage(MvcGameConfig.CANNON_IMAGE_RESOURCE, cannon.pos)
    )
  }

  override def visitMissile(missile: AbstractMissile): Unit = {
    this.gr(
      _.drawImage(
        new Image(MvcGameConfig.MISSILE_IMAGE_RESOURCE),
        missile.pos.dimX,
        missile.pos.dimY
      )
    )
    this.gg(
      _.drawImage((MvcGameConfig.MISSILE_IMAGE_RESOURCE), missile.pos)
    )
  }
}
