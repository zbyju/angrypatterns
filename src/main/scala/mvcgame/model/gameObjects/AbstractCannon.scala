package mvcgame.model.gameObjects

import mvcgame.model.Position
import mvcgame.visitor.GameObjectVisitor
import mvcgame.abstractfactory.GameObjectFactory

abstract class AbstractCannon(override val pos: Position, val gof: GameObjectFactory)
    extends GameObject(pos) {
  def moveUp(): Unit;
  def moveDown(): Unit;
  def shoot(): AbstractMissile;

  override def acceptVisitor(visitor: GameObjectVisitor): Unit =
    visitor.visitCannon(this);

}
