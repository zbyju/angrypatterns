package mvcgame.model.gameObjects

import mvcgame.model.{Position, Vector}
import mvcgame.visitor.Visitable

abstract class GameObject(val pos: Position) extends Visitable {
  def move(vector: Vector): Unit = this.pos.add(vector: Vector)
}
