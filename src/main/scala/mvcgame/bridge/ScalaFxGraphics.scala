package mvcgame.bridge

import scalafx.scene.canvas.GraphicsContext
import mvcgame.model.Position
import scalafx.scene.image.Image
import mvcgame.config.MvcGameConfig

class ScalaFxGraphics(gr: GraphicsContext) extends GameGraphicsImplementator {
  override def drawImage(path: String, position: Position): Unit =
    this.gr.drawImage(new Image(path), position.dimX, position.dimY);
  override def drawText(text: String, position: Position): Unit =
    this.gr.fillText(text, position.dimX, position.dimY);
  override def drawLine(beginPosition: Position, endPosition: Position): Unit =
    this.gr.strokeLine(
      beginPosition.dimX,
      beginPosition.dimY,
      endPosition.dimX,
      endPosition.dimY
    );
  override def clear(): Unit =
    this.gr.clearRect(0, 0, MvcGameConfig.MAX_X, MvcGameConfig.MAX_Y);
}
