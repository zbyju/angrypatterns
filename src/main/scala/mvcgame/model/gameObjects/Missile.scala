package mvcgame.model.gameObjects

import mvcgame.model.Position
import mvcgame.strategy.MovingStrategy

class Missile(
    override val pos: Position,
    override val initAngle: Double,
    override val initVelocity: Int,
    private val movingStrategy: MovingStrategy
) extends AbstractMissile(pos, initAngle, initVelocity) {

  override def move(): Unit = {
    this.movingStrategy.updatePosition(this);
  }

}
