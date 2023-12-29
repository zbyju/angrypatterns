package mvcgame.command

import mvcgame.model.GameModel

class CannonMoveDownCommand(subject: GameModel)
    extends AbstractGameCommand(subject) {
  override def execute(): Unit = subject.moveCannonDown()
}
