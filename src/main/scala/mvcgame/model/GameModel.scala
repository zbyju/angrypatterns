package mvcgame.model

import mvcgame.observer.{Observable, Observer, Aspect, CannonMoved}
import mvcgame.model.Position
import mvcgame.model.gameObjects.Cannon
import mvcgame.config.MvcGameConfig

class GameModel() extends Observable {
  val cannon: Cannon = new Cannon(
    Position(MvcGameConfig.CANNON_POS_X, MvcGameConfig.CANNON_POS_Y)
  )

  def moveCannonUp(): Unit = {
    this.cannon.moveUp()
    this.notifyObservers(CannonMoved)
  }
  def moveCannonDown(): Unit = {
    this.cannon.moveDown()
    this.notifyObservers(CannonMoved)
  }

}
