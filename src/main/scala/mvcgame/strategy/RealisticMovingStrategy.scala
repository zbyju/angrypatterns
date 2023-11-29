package mvcgame.strategy

import mvcgame.model.gameObjects.AbstractMissile
import mvcgame.model.Vector
import mvcgame.config.MvcGameConfig

class RealisticMovingStrategy extends MovingStrategy {
  override def updatePosition(missile: AbstractMissile): Unit = {
    val initVelocity = missile.initVelocity;
    val initAngle = missile.initAngle;
    val time = missile.getAge() / 100;
    val dX = initVelocity * time * Math.cos(initAngle);
    val dY = initVelocity * time * Math.sin(
      initAngle
    ) + (0.5 * MvcGameConfig.GRAVITY * time * time)

    missile.move(Vector(dX.toInt, dY.toInt));
  }
}
