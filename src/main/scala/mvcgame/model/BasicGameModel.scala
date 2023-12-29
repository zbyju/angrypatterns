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
import scala.collection.mutable.Queue
import scala.collection.mutable.Stack
import mvcgame.command.AbstractGameCommand

class BasicGameModel() extends GameModel {
  val sounder = GameObjectSounder()
  val gameObjectsFactory: GameObjectFactory = GameObjectFactoryA(this)
  val cannon: AbstractCannon = gameObjectsFactory.createCannon()
  var missiles = Seq[AbstractMissile]()
  def gameObjects: Seq[GameObject] = Seq(cannon) ++ missiles

  def movingStrategy: MovingStrategy = movingStrategies(movingStrategyIndex)

  val unexecutedCommands: Queue[AbstractGameCommand] =
    Queue()
  val executedCommands: Stack[AbstractGameCommand] = Stack()
  private def executeCommands(): Unit = {
    while (!unexecutedCommands.isEmpty) {
      val command = unexecutedCommands.dequeue()
      command.doExecute()
      executedCommands.push(command)
    }
  }

  def update(): Unit = {
    executeCommands()
    moveMissiles()
  }

  def moveCannonUp(): Unit = {
    this.cannon.moveUp()
    this.notifyObservers(CannonMoved)
  }

  def moveCannonDown(): Unit = {
    this.cannon.moveDown()
    this.notifyObservers(CannonMoved)
  }

  def aimCannonUp(): Unit = {
    this.cannon.aimUp()
    this.notifyObservers(CannonAimChanged)
  }

  def aimCannonDown(): Unit = {
    this.cannon.aimDown()
    this.notifyObservers(CannonAimChanged)
  }

  def cannonPowerUp(): Unit = {
    this.cannon.powerUp()
    this.notifyObservers(CannonPowerChanged)
  }

  def cannonPowerDown(): Unit = {
    this.cannon.powerDown()
    this.notifyObservers(CannonPowerChanged)

  }

  def shootCannon(): Unit = {
    val ms = this.cannon.shoot()
    missiles = missiles.appendedAll(ms)
    cannon.acceptVisitor(sounder)
    this.notifyObservers(MissileShot)
  }

  def increaseMissileCount() = {
    this.cannon.increaseMissileCount();
    this.notifyObservers(ShootingModeChanged);
  }
  def decreaseMissileCount() = {
    this.cannon.decreaseMissileCount();
    this.notifyObservers(ShootingModeChanged);
  }

  def moveMissiles(): Unit = {
    if (missiles.length > 0) {
      this.missiles.foreach(_.move());
      this.destroyMissiles();
      this.notifyObservers(MissilesMoved);
    }
  }

  private def destroyMissiles(): Unit = {
    missiles = missiles
      .filter(m =>
        (m.pos.dimX < MvcGameConfig.MAX_X) && (m.pos.dimX > 0) && (m.pos.dimY < MvcGameConfig.MAX_Y) && (m.pos.dimY > 0)
      )
  }

  def toggleMovingStrategy(): Unit =
    movingStrategyIndex = (movingStrategyIndex + 1) % movingStrategies.length

  def toggleShootingMode() = {
    this.cannon.toggleShootingMode();
    this.notifyObservers(ShootingModeChanged);
  }

  override def registerCommand(command: AbstractGameCommand): Unit =
    this.unexecutedCommands.enqueue(command)

  override def undoLastCommand(): Unit = {
    if (!this.executedCommands.isEmpty) {
      val before = createMemento()
      this.executedCommands.pop.undoExecute();
      this.notifyObservers(CannonMoved)

      if (before == createMemento()) {
        undoLastCommand()
      }

    }
  }

  case class Memento(cannonPosX: Int, cannonPosY: Int)

  def createMemento(): Any = Memento(cannon.pos.dimX, cannon.pos.dimY);

  def setMemento(memento: Any): Any = memento match {
    case m: Memento => {
      cannon.pos.dimX = m.cannonPosX;
      cannon.pos.dimY = m.cannonPosY;
    }
    case _ => throw new IllegalArgumentException()
  }
}
