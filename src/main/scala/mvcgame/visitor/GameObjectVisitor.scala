package mvcgame.visitor

import mvcgame.model.gameObjects.AbstractCannon
import mvcgame.model.gameObjects.AbstractMissile

trait GameObjectVisitor {
  def visitCannon(cannon: AbstractCannon): Unit
  def visitMissile(missile: AbstractMissile): Unit
}
