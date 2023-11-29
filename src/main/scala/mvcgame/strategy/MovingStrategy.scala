package mvcgame.strategy

import mvcgame.model.gameObjects.AbstractMissile

trait MovingStrategy {
  def updatePosition(missile: AbstractMissile): Unit
}
