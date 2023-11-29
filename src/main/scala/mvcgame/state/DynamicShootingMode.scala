package mvcgame.state

import mvcgame.model.gameObjects.AbstractCannon

class DynamicShootingMode(val numberOfMissiles: Int) extends ShootingMode {
  override def shoot(cannon: AbstractCannon): Unit = {
    var n = numberOfMissiles
    if (n % 2 == 1) {
      cannon.primitiveShoot()
      n -= 1
    }
    (0 until n).foreach(i => {
      if (i % 2 == 0) {
        for (_ <- 0 to i / 2) {
          cannon.aimUp()
        }
        cannon.primitiveShoot()
        for (_ <- 0 to i / 2) {
          cannon.aimDown()
        }
      } else {
        for (_ <- 0 to i / 2) {
          cannon.aimDown()
        }
        cannon.primitiveShoot()
        for (_ <- 0 to i / 2) {
          cannon.aimUp()
        }
      }
    })
  }
}
