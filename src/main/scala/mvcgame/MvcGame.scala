package mvcgame

import mvcgame.view.GameView
import mvcgame.model.BasicGameModel
import mvcgame.controller.GameController
import scala.collection.mutable.ArrayBuffer
import mvcgame.nullObject.Maybe
import mvcgame.memento.CareTaker
import mvcgame.bridge.GameGraphics
import mvcgame.proxy.GameModelProxy

class MvcGame() {
  val model: GameModelProxy = new GameModelProxy(new BasicGameModel())
  val view: GameView = new GameView(model)
  val controller: GameController = view.controller
  CareTaker().setModel(model)

  def setGameGraphics(gameGraphics: GameGraphics): Unit =
    view.setGameGraphics(gameGraphics)

  def processPressedKeys(pressedKeyCodes: ArrayBuffer[String]): Unit = {
    this.controller.processPressedKeys(pressedKeyCodes)
  }
}
