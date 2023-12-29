package mvcgame.bridge

import mvcgame.model.Position

trait GameGraphicsImplementator {
  def drawImage(path: String, position: Position): Unit
  def drawText(text: String, position: Position): Unit
  def drawLine(start: Position, end: Position): Unit
  def clear(): Unit
}
