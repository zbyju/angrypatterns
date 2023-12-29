package mvcgame.command

import mvcgame.model.GameModel

class CannonPowerDownCommand(subject: GameModel)
    extends AbstractGameCommand(subject) {
  override def execute(): Unit = subject.cannonPowerDown()
}
