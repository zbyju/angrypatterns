package mvcgame.view

import mvcgame.model.GameModel
import mvcgame.observer.Observer
import mvcgame.controller.GameController
import mvcgame.config.MvcGameConfig
import scalafx.scene.canvas.GraphicsContext
import scalafx.scene.image.Image
import mvcgame.nullObject.Maybe
import mvcgame.observer.{Aspect, CannonMoved}

class GameView(val model: GameModel) extends Observer {
  private var gc: Maybe[GraphicsContext] = Maybe.None
  val controller: GameController = new GameController(this.model)

  this.model.subscribe(this, CannonMoved);
  render()

  def setGraphicsContext(newGc: GraphicsContext): Unit = {
    gc = Maybe(newGc)
    render()
  }

  private def render(): Unit = {
    this.gc(_.clearRect(0, 0, MvcGameConfig.MAX_X, MvcGameConfig.MAX_Y))
    this.drawCannon()
  }

  private def drawCannon(): Unit = {
    this.gc(
      _.drawImage(
        new Image(MvcGameConfig.CANNON_IMAGE_RESOURCE),
        this.model.cannon.pos.dimX,
        this.model.cannon.pos.dimY
      )
    )
  }

  override def update(aspect: Aspect): Unit = aspect match {
    case CannonMoved => this.render()
    case _           =>
  }

}
