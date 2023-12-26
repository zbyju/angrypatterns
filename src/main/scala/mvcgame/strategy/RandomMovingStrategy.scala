package mvcgame.strategy

import mvcgame.model.gameObjects.AbstractMissile
import scala.util.Random
import mvcgame.model.Vector

class RandomMovingStrategy extends MovingStrategy {
  override def updatePosition(missile: AbstractMissile): Unit = {
    val initVelocity = missile.initVelocity
    val initAngle = missile.initAngle
    val time = missile.getAge() / 100

    val angleAdjustmentRange = Math.toRadians(45)
    val randomAngleAdjustment =
      (Random.nextDouble() * 2 - 1) * angleAdjustmentRange
    val currentAngle = initAngle + randomAngleAdjustment

    val dX = initVelocity * time * Math.cos(currentAngle)
    val dY = initVelocity * time * Math.sin(currentAngle)

    missile.move(Vector(dX.toInt, dY.toInt))
  }
}
