package mvcgame.bridge

import mvcgame.model.Position

class GameGraphics(implementor: GameGraphicsImplementator)
    extends GameGraphical {
  override def drawImage(path: String, position: Position): Unit =
    this.implementor.drawImage(path, position)
  override def drawText(text: String, position: Position): Unit =
    this.implementor.drawText(text, position)
  override def drawRectangle(leftTop: Position, rightBottom: Position): Unit = {
    this.implementor
      .drawLine(leftTop, Position(rightBottom.dimX, leftTop.dimX))
    this.implementor
      .drawLine(Position(rightBottom.dimX, leftTop.dimY), rightBottom)
    this.implementor
      .drawLine(rightBottom, Position(leftTop.dimX, rightBottom.dimY))
    this.implementor
      .drawLine(Position(leftTop.dimX, rightBottom.dimY), leftTop)
  }
  override def clear(): Unit = this.implementor.clear()

}
