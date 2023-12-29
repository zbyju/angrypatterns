package mvcgame.command

import mvcgame.model.GameModel

class CannonPowerUpCommand(subject: GameModel)
    extends AbstractGameCommand(subject) {
  override def execute(): Unit = subject.cannonPowerUp()
}
