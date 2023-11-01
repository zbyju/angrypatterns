package fit.cvut.cz.mvcgame.view

import fit.cvut.cz.mvcgame.model.GameModel
import fit.cvut.cz.mvcgame.observer.Observer
import fit.cvut.cz.mvcgame.controller.GameController
import scalafx.scene.canvas.GraphicsContext
import fit.cvut.cz.mvcgame.config.MvcGameConfig
import scalafx.scene.image.Image

class GameView(val model: GameModel, val gr: GraphicsContext) extends Observer {
  val controller: GameController = new GameController(this.model)
  this.model.registerObserver(this);
  render()

  private def render(): Unit = {
    this.gr.clearRect(0, 0, MvcGameConfig.MAX_X, MvcGameConfig.MAX_Y)
    this.drawCannon()
  }

  private def drawCannon(): Unit = {
    this.gr.drawImage(
      new Image(MvcGameConfig.CANNON_IMAGE_RESOURCE),
      this.model.cannon.pos.dimX,
      this.model.cannon.pos.dimY
    )
  }

  override def update(): Unit = {
    this.render()
  }
}
