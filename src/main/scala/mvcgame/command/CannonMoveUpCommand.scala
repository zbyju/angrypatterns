package mvcgame.command

import mvcgame.model.GameModel

class CannonMoveUpCommand(subject: GameModel)
    extends AbstractGameCommand(subject) {
  override def execute(): Unit = subject.moveCannonUp()
}
