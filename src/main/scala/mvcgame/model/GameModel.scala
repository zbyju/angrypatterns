package mvcgame.model

import mvcgame.observer.*
import mvcgame.model.Position
import mvcgame.model.gameObjects.Cannon
import mvcgame.config.MvcGameConfig
import mvcgame.model.gameObjects.AbstractCannon
import mvcgame.abstractfactory.GameObjectFactory
import mvcgame.model.gameObjects.AbstractMissile
import mvcgame.observer.MissileShot
import mvcgame.observer.MissilesMoved
import mvcgame.model.gameObjects.GameObject
import mvcgame.abstractfactory.GameObjectFactoryA
import mvcgame.visitor.GameObjectSounder
import mvcgame.strategy.MovingStrategy
import mvcgame.strategy.SimpleMovingStrategy
import mvcgame.strategy.RealisticMovingStrategy
import mvcgame.command.AbstractGameCommand
import mvcgame.strategy.CircleMovingStrategy
import mvcgame.strategy.RandomMovingStrategy

trait GameModel() extends Observable {
  val cannon: AbstractCannon
  var missiles: Seq[AbstractMissile]
  def gameObjects: Seq[GameObject]

  protected var movingStrategyIndex: Int = 0
  protected val movingStrategies: Seq[MovingStrategy] = Seq(
    SimpleMovingStrategy(),
    RealisticMovingStrategy(),
    RandomMovingStrategy(),
    CircleMovingStrategy()
  )
  def movingStrategy: MovingStrategy

  def update(): Unit
  def moveCannonUp(): Unit
  def moveCannonDown(): Unit
  def aimCannonUp(): Unit
  def aimCannonDown(): Unit
  def cannonPowerUp(): Unit
  def cannonPowerDown(): Unit
  def increaseMissileCount(): Unit
  def decreaseMissileCount(): Unit
  def shootCannon(): Unit
  def moveMissiles(): Unit
  def toggleMovingStrategy(): Unit
  def toggleShootingMode(): Unit

  def registerCommand(command: AbstractGameCommand): Unit
  def undoLastCommand(): Unit

  def createMemento(): Any
  def setMemento(memento: Any): Any
}
