package mvcgame

import mvcgame.view.GameView
import mvcgame.model.GameModel
import mvcgame.controller.GameController
import scalafx.scene.canvas.GraphicsContext
import scala.collection.mutable.ArrayBuffer
import mvcgame.nullObject.Maybe

class MvcGame() {
  val model: GameModel = new GameModel()
  val view: GameView = new GameView(model)
  val controller: GameController = view.controller

  def setGraphicsContext(gc: GraphicsContext): Unit =
    view.setGraphicsContext(gc)

  def processPressedKeys(pressedKeyCodes: ArrayBuffer[String]): Unit = {
    this.controller.processPressedKeys(pressedKeyCodes)
  }
}