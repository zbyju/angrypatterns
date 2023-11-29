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

class GameModel() extends Observable {
  val sounder = GameObjectSounder()
  val gameObjectsFactory: GameObjectFactory = GameObjectFactoryA(this)
  val cannon: AbstractCannon = gameObjectsFactory.createCannon()
  var missiles = Seq[AbstractMissile]()
  var movingStrategy: MovingStrategy = SimpleMovingStrategy()
  def gameObjects = Seq[GameObject](cannon) ++ missiles

  def update(): Unit = {
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

  def moveMissiles(): Unit = {
    if (missiles.length > 0) {
      this.missiles.foreach(_.move());
      this.destroyMissiles();
      this.notifyObservers(MissilesMoved);
    }
  }

  private def destroyMissiles(): Unit = {
    missiles = missiles
      .filter(_.pos.dimX < MvcGameConfig.MAX_X)
  }

  def toggleMovingStrategy(): Unit = movingStrategy match {
    case _: SimpleMovingStrategy => movingStrategy = RealisticMovingStrategy()
    case _: RealisticMovingStrategy => movingStrategy = SimpleMovingStrategy()
    case _: MovingStrategy          => movingStrategy = SimpleMovingStrategy()
  }

  def toggleShootingMode() = {
    this.cannon.toggleShootingMode();
    this.notifyObservers(ShootingModeChanged);
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
