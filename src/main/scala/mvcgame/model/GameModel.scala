package mvcgame.model

import mvcgame.observer.{Observable, Observer, Aspect, CannonMoved}
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

class GameModel() extends Observable {
  val sounder = GameObjectSounder()
  val gameObjectsFactory: GameObjectFactory = GameObjectFactoryA(this)
  val cannon: AbstractCannon = gameObjectsFactory.createCannon()
  var missiles = Seq[AbstractMissile]()
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

  def shootCannon(): Unit = {
    val missile = this.cannon.shoot()
    missiles = missiles.appended(missile)
    cannon.acceptVisitor(sounder)
    this.notifyObservers(MissileShot)
  }

  def moveMissiles(): Unit = {
    if (missiles.length > 0) {
      this.missiles.foreach(_.move(new Vector(MvcGameConfig.MOVE_STEP, 0)));
      this.destroyMissiles();
      this.notifyObservers(MissilesMoved);
    }
  }

  private def destroyMissiles(): Unit = {
    missiles = missiles
      .filter(_.pos.dimX < MvcGameConfig.MAX_X)
  }
}
