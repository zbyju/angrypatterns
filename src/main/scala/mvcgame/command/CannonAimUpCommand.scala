package mvcgame.command

import mvcgame.model.GameModel

class CannonAimUpCommand(subject: GameModel)
    extends AbstractGameCommand(subject) {
  override def execute(): Unit = subject.aimCannonUp()
}
