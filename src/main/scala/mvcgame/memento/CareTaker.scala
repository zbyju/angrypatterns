package mvcgame.memento

import mvcgame.model.GameModel
import scala.collection.mutable.Stack
import mvcgame.nullObject.Maybe

class CareTaker {
  private var model: Maybe[GameModel] = Maybe.None
  private val mementos: Stack[Any] = Stack()

  def setModel(model: GameModel): Unit = {
    this.model = Maybe.Some(model)
  }

  def createMemento(): Unit = {
    if (this.model.isDefined) {
      this.mementos.push(this.model.get.createMemento());
    }
  }

  def setMemento(): Unit = {
    if (this.model.isDefined && this.mementos.length > 0) {
      this.model.get.setMemento(this.mementos.pop());
    }
  }

}

object CareTaker {
  private var instance: Maybe[CareTaker] = Maybe.None

  def apply(): CareTaker = instance match {
    case Maybe.None => {
      val i = new CareTaker()
      instance = Maybe.Some(i)
      i
    }
    case Maybe.Some(i) => i
  }

}
