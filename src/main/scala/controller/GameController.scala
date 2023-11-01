package fit.cvut.cz.mvcgame.controller

import fit.cvut.cz.mvcgame.model.GameModel
import fit.cvut.cz.mvcgame.config.MvcGameConfig
import scala.collection.mutable.ArrayBuffer

class GameController(val model: GameModel) {
  def processPressedKeys(pressedKeyCodes: ArrayBuffer[String]): Unit = {
    pressedKeyCodes.foreach(code =>
      code match
        case MvcGameConfig.UP_KEY   => model.moveCannonUp()
        case MvcGameConfig.DOWN_KEY => model.moveCannonDown()
        case MvcGameConfig.EXIT_KEY => System.exit(0)
    )
  }
}
