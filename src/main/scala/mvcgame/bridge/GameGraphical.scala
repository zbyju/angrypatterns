package mvcgame.bridge

import mvcgame.model.Position

trait GameGraphical {
  def drawImage(path: String, position: Position): Unit
  def drawText(text: String, position: Position): Unit
  def drawRectangle(topLeft: Position, bottomRight: Position): Unit
  def clear(): Unit
}
