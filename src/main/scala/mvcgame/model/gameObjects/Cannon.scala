package mvcgame.model.gameObjects

import mvcgame.model.gameObjects.GameObject
import mvcgame.model.{Position, Vector}
import mvcgame.config.{MvcGameConfig}

class Cannon(override val pos: Position) extends GameObject(pos) {
  def moveUp(): Unit = this.move(Vector(0, -MvcGameConfig.MOVE_STEP))
  def moveDown(): Unit = this.move(Vector(0, MvcGameConfig.MOVE_STEP))
}
