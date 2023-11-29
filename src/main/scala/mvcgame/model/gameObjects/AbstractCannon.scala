package mvcgame.model.gameObjects

import mvcgame.model.Position
import mvcgame.visitor.GameObjectVisitor
import mvcgame.abstractfactory.GameObjectFactory
import mvcgame.state.*
import scala.collection.mutable.ListBuffer

abstract class AbstractCannon(
    override val pos: Position,
    val gof: GameObjectFactory
) extends GameObject(pos) {

  protected var shootingMode: ShootingMode;
  protected var power: Int;
  protected var angle: Double;

  def moveUp(): Unit;
  def moveDown(): Unit;
  def aimUp(): Unit;
  def aimDown(): Unit;
  def powerUp(): Unit;
  def powerDown(): Unit;
  def shoot(): ListBuffer[AbstractMissile];
  def primitiveShoot(): Unit;
  def toggleShootingMode(): Unit;
  def increaseMissileCount(): Unit;
  def decreaseMissileCount(): Unit;

  override def acceptVisitor(visitor: GameObjectVisitor): Unit =
    visitor.visitCannon(this);

}

object AbstractCannon {
  val SINGLE_SHOOTING_MODE = SingleShootingMode()
  val DOUBLE_SHOOTING_MODE = DoubleShootingMode()
  val DYNAMIC_SHOOTING_MODE = DynamicShootingMode(1)
}
