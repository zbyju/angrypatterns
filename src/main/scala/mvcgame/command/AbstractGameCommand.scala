package mvcgame.command

import mvcgame.model.GameModel

abstract class AbstractGameCommand(subject: GameModel) {
  private var memento: Any = null

  protected def execute(): Unit

  def doExecute(): Unit = {
    memento = subject.createMemento()
    execute()
  }

  def undoExecute(): Unit =
    subject.setMemento(this.memento)

}
