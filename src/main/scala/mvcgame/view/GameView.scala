package mvcgame.view

import mvcgame.model.GameModel
import mvcgame.observer.Observer
import mvcgame.controller.GameController
import mvcgame.config.MvcGameConfig
import scalafx.scene.canvas.GraphicsContext
import mvcgame.nullObject.Maybe
import mvcgame.observer.{Aspect, CannonMoved}
import mvcgame.visitor.GameObjectRenderer
import mvcgame.observer.MissileShot
import mvcgame.observer.MissilesMoved

class GameView(val model: GameModel) extends Observer {
  private var gc: Maybe[GraphicsContext] = Maybe.None
  private val renderer: GameObjectRenderer = new GameObjectRenderer()
  val controller: GameController = new GameController(this.model)

  this.model.subscribe(this, CannonMoved);
  this.model.subscribe(this, MissileShot);
  this.model.subscribe(this, MissilesMoved);
  render()

  private def render(): Unit = {
    this.gc(_.clearRect(0, 0, MvcGameConfig.MAX_X, MvcGameConfig.MAX_Y))
    this.model.gameObjects.foreach(_.acceptVisitor(this.renderer))
  }

  def setGraphicsContext(newGc: GraphicsContext): Unit = {
    gc = Maybe(newGc)
    renderer.setGraphicsContext(newGc)
    render()
  }

  override def update(aspect: Aspect): Unit = aspect match {
    case CannonMoved   => this.render()
    case MissileShot   => this.render()
    case MissilesMoved => this.render()
    case _             =>
  }

}
