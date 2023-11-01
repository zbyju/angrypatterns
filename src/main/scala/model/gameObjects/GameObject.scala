package fit.cvut.cz.mvcgame.model.gameObjects

import fit.cvut.cz.mvcgame.model.{Position, Vector}

abstract class GameObject(val pos: Position) {
  def move(vector: Vector): Unit = this.pos.add(vector: Vector)
}
