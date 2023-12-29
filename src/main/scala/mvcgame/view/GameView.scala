package mvcgame.view

import mvcgame.model.GameModel
import mvcgame.observer.Observer
import mvcgame.controller.GameController
import mvcgame.config.MvcGameConfig
import mvcgame.nullObject.Maybe
import mvcgame.observer.{Aspect, CannonMoved}
import mvcgame.visitor.GameObjectRenderer
import mvcgame.observer.MissileShot
import mvcgame.observer.MissilesMoved
import mvcgame.bridge.GameGraphics

class GameView(val model: GameModel) extends Observer {
  private var gameGraphics: Maybe[GameGraphics] = Maybe.None
  private val renderer: GameObjectRenderer = new GameObjectRenderer()
  val controller: GameController = new GameController(this.model)

  this.model.subscribe(this, CannonMoved);
  this.model.subscribe(this, MissileShot);
  this.model.subscribe(this, MissilesMoved);
  render()

  private def render(): Unit = {
    this.gameGraphics(_.clear())
    this.model.gameObjects.foreach(_.acceptVisitor(this.renderer))
  }

  def setGameGraphics(gg: GameGraphics): Unit = {
    gameGraphics = Maybe.Some(gg)
    renderer.setGameGraphics(gg)
    render()
  }

  override def update(aspect: Aspect): Unit = aspect match {
    case CannonMoved   => this.render()
    case MissileShot   => this.render()
    case MissilesMoved => this.render()
    case _             =>
  }

}
