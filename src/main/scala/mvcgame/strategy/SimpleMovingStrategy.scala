package mvcgame.strategy

import mvcgame.model.gameObjects.AbstractMissile
import mvcgame.model.Vector

class SimpleMovingStrategy extends MovingStrategy {
  def updatePosition(missile: AbstractMissile): Unit = {
    val initVelocity = missile.initVelocity
    val initAngle = missile.initAngle
    val time = missile.getAge() / 100
    val dX = (initVelocity * time * Math.cos(initAngle))
    val dY = (initVelocity * time * Math.sin(initAngle))
    missile.move(Vector(dX.toInt, dY.toInt))
  }
}
