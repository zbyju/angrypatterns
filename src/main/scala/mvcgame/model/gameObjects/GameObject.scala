package mvcgame.model.gameObjects

import mvcgame.model.{Position, Vector}

abstract class GameObject(val pos: Position) {
  def move(vector: Vector): Unit = this.pos.add(vector: Vector)
}
