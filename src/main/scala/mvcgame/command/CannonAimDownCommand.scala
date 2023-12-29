package mvcgame.command

import mvcgame.model.GameModel

class CannonAimDownCommand(subject: GameModel)
    extends AbstractGameCommand(subject) {
  override def execute(): Unit = subject.aimCannonDown()
}
