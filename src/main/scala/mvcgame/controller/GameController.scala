package mvcgame.controller

import mvcgame.model.GameModel
import mvcgame.config.MvcGameConfig
import scala.collection.mutable.ArrayBuffer
import mvcgame.memento.CareTaker

class GameController(val model: GameModel) {
  def processPressedKeys(pressedKeyCodes: ArrayBuffer[String]): Unit = {
    pressedKeyCodes.foreach(code =>
      code match
        case MvcGameConfig.UP_KEY               => model.moveCannonUp()
        case MvcGameConfig.DOWN_KEY             => model.moveCannonDown()
        case MvcGameConfig.SHOOT_KEY            => model.shootCannon()
        case MvcGameConfig.AIM_UP_KEY           => model.aimCannonUp()
        case MvcGameConfig.AIM_DOWN_KEY         => model.aimCannonDown()
        case MvcGameConfig.POWER_UP_KEY         => model.cannonPowerUp()
        case MvcGameConfig.POWER_DOWN_KEY       => model.cannonPowerDown()
        case MvcGameConfig.MOVING_STRATEGY_KEY  => model.toggleMovingStrategy()
        case MvcGameConfig.SHOOTING_MODE_KEY    => model.toggleShootingMode()
        case MvcGameConfig.ADD_MISSILE_KEY      => model.increaseMissileCount()
        case MvcGameConfig.DEL_MISSILE_KEY      => model.decreaseMissileCount()
        case MvcGameConfig.STORE_SNAPSHOT_KEY   => CareTaker().createMemento()
        case MvcGameConfig.RESTORE_SNAPSHOT_KEY => CareTaker().setMemento()
        case MvcGameConfig.EXIT_KEY             => System.exit(0)
        case _                                  =>
    )
    pressedKeyCodes.clear()
    model.update()
  }
}
