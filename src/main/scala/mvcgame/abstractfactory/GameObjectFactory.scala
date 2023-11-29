package mvcgame.abstractfactory

import mvcgame.model.gameObjects.AbstractCannon
import mvcgame.model.gameObjects.AbstractMissile

trait GameObjectFactory {
  def createCannon(): AbstractCannon;
  def createMissile(): AbstractMissile;
}
