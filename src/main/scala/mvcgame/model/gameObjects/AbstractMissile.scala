package mvcgame.model.gameObjects

import mvcgame.model.Position
import mvcgame.visitor.GameObjectVisitor

abstract class AbstractMissile(
    pos: Position,
    val initAngle: Double,
    val initVelocity: Int
) extends LifetimeLimitedGameObject(pos) {

  def move(): Unit

  override def acceptVisitor(visitor: GameObjectVisitor): Unit =
    visitor.visitMissile(this);
}
