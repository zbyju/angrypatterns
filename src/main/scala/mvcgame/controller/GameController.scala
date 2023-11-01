package mvcgame.controller

import mvcgame.model.GameModel
import mvcgame.config.MvcGameConfig
import scala.collection.mutable.ArrayBuffer

class GameController(val model: GameModel) {
  def processPressedKeys(pressedKeyCodes: ArrayBuffer[String]): Unit = {
    pressedKeyCodes.foreach(code =>
      code match
        case MvcGameConfig.UP_KEY   => model.moveCannonUp()
        case MvcGameConfig.DOWN_KEY => model.moveCannonDown()
        case MvcGameConfig.EXIT_KEY => System.exit(0)
        case _                      =>
    )
  }
}
