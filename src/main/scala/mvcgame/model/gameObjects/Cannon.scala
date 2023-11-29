package mvcgame.model.gameObjects

import mvcgame.model.gameObjects.GameObject
import mvcgame.model.{Position, Vector}
import mvcgame.config.{MvcGameConfig}
import mvcgame.abstractfactory.GameObjectFactory
import mvcgame.state.*
import scala.collection.mutable.ListBuffer

class Cannon(override val pos: Position, override val gof: GameObjectFactory)
    extends AbstractCannon(pos, gof) {

  private var shootingBatch = ListBuffer[AbstractMissile]()
  protected var power = MvcGameConfig.INIT_POWER
  protected var angle = MvcGameConfig.INIT_ANGLE
  protected var shootingMode = AbstractCannon.SINGLE_SHOOTING_MODE

  override def aimUp(): Unit = angle -= MvcGameConfig.ANGLE_STEP
  override def aimDown(): Unit = angle += MvcGameConfig.ANGLE_STEP
  override def powerUp(): Unit =
    power = Math.min(MvcGameConfig.MAX_POWER, power + MvcGameConfig.POWER_STEP);

  override def powerDown(): Unit =
    power = Math.max(MvcGameConfig.MIN_POWER, power - MvcGameConfig.POWER_STEP);
  override def moveUp(): Unit = move(Vector(0, -MvcGameConfig.MOVE_STEP))
  override def moveDown(): Unit = move(Vector(0, MvcGameConfig.MOVE_STEP))

  override def shoot(): ListBuffer[AbstractMissile] = {
    shootingBatch.clear()
    shootingMode.shoot(this)
    shootingBatch
  }

  override def primitiveShoot(): Unit =
    shootingBatch += gof.createMissile(angle, power)

  def toggleShootingMode(): Unit = shootingMode match {
    case _: SingleShootingMode =>
      shootingMode = AbstractCannon.DOUBLE_SHOOTING_MODE
    case _: DoubleShootingMode =>
      shootingMode = AbstractCannon.SINGLE_SHOOTING_MODE
    case _: ShootingMode => shootingMode = AbstractCannon.SINGLE_SHOOTING_MODE
  }
}
