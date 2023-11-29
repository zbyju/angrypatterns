package mvcgame.model.gameObjects

import mvcgame.model.gameObjects.GameObject
import mvcgame.model.{Position, Vector}
import mvcgame.config.{MvcGameConfig}
import mvcgame.abstractfactory.GameObjectFactory

class Cannon(override val pos: Position, override val gof: GameObjectFactory)
    extends AbstractCannon(pos, gof) {
  override def moveUp(): Unit = this.move(Vector(0, -MvcGameConfig.MOVE_STEP))
  override def moveDown(): Unit = this.move(Vector(0, MvcGameConfig.MOVE_STEP))
  override def shoot(): AbstractMissile = gof.createMissile()
}
