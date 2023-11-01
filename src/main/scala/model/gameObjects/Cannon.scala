package fit.cvut.cz.mvcgame.model.gameObjects

import fit.cvut.cz.mvcgame.model.gameObjects.GameObject
import fit.cvut.cz.mvcgame.model.{Position, Vector}
import fit.cvut.cz.mvcgame.config.{MvcGameConfig}

class Cannon(override val pos: Position) extends GameObject(pos) {
  def moveUp(): Unit = this.move(Vector(0, -MvcGameConfig.MOVE_STEP))
  def moveDown(): Unit = this.move(Vector(0, MvcGameConfig.MOVE_STEP))
}
