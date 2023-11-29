package mvcgame.state

import mvcgame.model.gameObjects.AbstractCannon

class DoubleShootingMode extends ShootingMode {
  override def shoot(cannon: AbstractCannon): Unit = {
    cannon.aimUp();
    cannon.primitiveShoot();
    cannon.aimDown();
    cannon.aimDown();
    cannon.primitiveShoot();
    cannon.aimUp();
  }
}
