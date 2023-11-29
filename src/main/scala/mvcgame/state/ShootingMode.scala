package mvcgame.state

import mvcgame.model.gameObjects.AbstractCannon

trait ShootingMode {
  val name: String = this.getClass().getSimpleName()
  def shoot(cannon: AbstractCannon): Unit
}
