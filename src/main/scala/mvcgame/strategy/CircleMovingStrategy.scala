package mvcgame.strategy

import mvcgame.model.gameObjects.AbstractMissile
import mvcgame.model.Vector
import mvcgame.config.MvcGameConfig

class CircleMovingStrategy extends MovingStrategy {
  def updatePosition(missile: AbstractMissile): Unit = {
    val initAngle = missile.initAngle
    val initVelocity =
      missile.initVelocity * MvcGameConfig.CIRCLE_SPEED_MULTIPLIER
    val time = missile.getAge() / 100.0

    val growthRate = MvcGameConfig.CIRCLE_GROWTH
    val circleFrequency =
      MvcGameConfig.CIRCLE_FREQUENCY - (growthRate * 0.01 * time)
    val circleRadius = MvcGameConfig.CIRCLE_RADIUS + (growthRate * time)

    val circleOffsetX = circleRadius * Math.cos(time * circleFrequency)
    val circleOffsetY = circleRadius * Math.sin(time * circleFrequency)

    val linearDX = initVelocity * time * Math.cos(initAngle)
    val linearDY = initVelocity * time * Math.sin(initAngle)

    val dX = (linearDX + circleOffsetX).toInt
    val dY = (linearDY + circleOffsetY).toInt

    missile.move(Vector(dX, dY))
  }
}
