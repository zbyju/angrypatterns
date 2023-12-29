package mvcgame.proxy

import mvcgame.observer.Observer
import mvcgame.model.GameModel
import mvcgame.observer.Aspect
import mvcgame.command.AbstractGameCommand
import mvcgame.strategy.MovingStrategy
import mvcgame.model.gameObjects.GameObject
import mvcgame.model.gameObjects.AbstractMissile
import mvcgame.model.gameObjects.AbstractCannon

class GameModelProxy(subject: GameModel) extends GameModel {
  override val cannon: AbstractCannon = subject.cannon
  var missiles: Seq[AbstractMissile] = subject.missiles
  override def gameObjects = subject.gameObjects

  override def movingStrategy: MovingStrategy = subject.movingStrategy

  override def update(): Unit = subject.update()

  override def moveCannonUp(): Unit = subject.moveCannonUp()
  override def moveCannonDown(): Unit = subject.moveCannonDown()
  override def aimCannonUp(): Unit = subject.aimCannonUp()
  override def aimCannonDown(): Unit = subject.aimCannonDown()
  override def cannonPowerUp(): Unit = subject.cannonPowerUp()
  override def cannonPowerDown(): Unit = subject.cannonPowerDown()
  override def increaseMissileCount(): Unit = subject.increaseMissileCount()
  override def decreaseMissileCount(): Unit = subject.decreaseMissileCount()
  override def moveMissiles(): Unit = subject.moveMissiles()
  override def shootCannon(): Unit = subject.shootCannon()
  override def toggleMovingStrategy(): Unit = subject.toggleMovingStrategy()
  override def toggleShootingMode(): Unit = subject.toggleShootingMode()

  override def createMemento(): Any = subject.createMemento()
  override def setMemento(memento: Any): Unit = subject.setMemento(memento)

  override def subscribe(observer: Observer, aspect: Aspect): Unit =
    subject.subscribe(observer, aspect)
  override def unsubscribe(observer: Observer, aspect: Aspect): Unit =
    subject.unsubscribe(observer, aspect)
  override def notifyObservers(aspect: Aspect): Unit =
    subject.notifyObservers(aspect)

  override def registerCommand(command: AbstractGameCommand): Unit =
    subject.registerCommand(command)
  override def undoLastCommand(): Unit = subject.undoLastCommand()
}
