package mvcgame.command

import mvcgame.model.GameModel

class ToggleShootingModeCommand(subject: GameModel)
    extends AbstractGameCommand(subject) {
  override def execute(): Unit = subject.toggleShootingMode()
}
