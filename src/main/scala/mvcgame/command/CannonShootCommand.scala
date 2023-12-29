package mvcgame.command

import mvcgame.model.GameModel

class CannonShootCommand(subject: GameModel)
    extends AbstractGameCommand(subject) {
  override def execute(): Unit = subject.shootCannon()
}
