package mvcgame.model.gameObjects

import mvcgame.model.Position
import mvcgame.visitor.GameObjectVisitor

abstract class AbstractMissile(pos: Position) extends GameObject(pos) {
  override def acceptVisitor(visitor: GameObjectVisitor): Unit =
    visitor.visitMissile(this);
}
