package mvcgame.model

import mvcgame.model.Vector

case class Position(var dimX: Int, var dimY: Int) {
  def add(vector: Vector): Unit = {
    dimX += vector.dX
    dimY += vector.dY
  }
}
