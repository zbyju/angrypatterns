package mvcgame.model.gameObjects

import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import mvcgame.model.Position

abstract class LifetimeLimitedGameObject(pos: Position)
    extends GameObject(pos) {

  protected val bornAt: LocalDateTime = LocalDateTime.now();

  def getAge(): Long = {
    ChronoUnit.MILLIS.between(this.bornAt, LocalDateTime.now())
  }
}
