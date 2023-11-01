package fit.cvut.cz.mvcgame

import fit.cvut.cz.mvcgame.view.GameView
import fit.cvut.cz.mvcgame.model.GameModel
import fit.cvut.cz.mvcgame.controller.GameController
import scalafx.scene.canvas.GraphicsContext
import scala.collection.mutable.ArrayBuffer

class MvcGame(gc: GraphicsContext) {
  val model: GameModel = new GameModel()
  val view: GameView = new GameView(model, gc)
  val controller: GameController = view.controller

  def processPressedKeys(pressedKeyCodes: ArrayBuffer[String]): Unit = {
    this.controller.processPressedKeys(pressedKeyCodes)
  }
}
