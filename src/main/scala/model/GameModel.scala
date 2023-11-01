package fit.cvut.cz.mvcgame.model

import fit.cvut.cz.mvcgame.observer.{Observable, Observer}
import fit.cvut.cz.mvcgame.model.Position
import fit.cvut.cz.mvcgame.model.gameObjects.Cannon
import fit.cvut.cz.mvcgame.config.MvcGameConfig

class GameModel() extends Observable {
  val cannon: Cannon = new Cannon(
    Position(MvcGameConfig.CANNON_POS_X, MvcGameConfig.CANNON_POS_Y)
  )

  def moveCannonUp(): Unit = {
    this.cannon.moveUp()
    this.notifyObservers()
  }
  def moveCannonDown(): Unit = {
    this.cannon.moveDown()
    this.notifyObservers()
  }

  override def registerObserver(observer: Observer): Unit =
    this.observers += observer;
  override def unregisterObserver(observer: Observer): Unit =
    this.observers -= observer;
  override def notifyObservers(): Unit = {
    this.observers.foreach(o => o.update())
  }
}
