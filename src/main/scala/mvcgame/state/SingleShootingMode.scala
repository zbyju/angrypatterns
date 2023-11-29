package mvcgame.state

import mvcgame.model.gameObjects.AbstractCannon

class SingleShootingMode extends ShootingMode {
  override def shoot(cannon: AbstractCannon): Unit = {
    cannon.primitiveShoot();
  }
}
