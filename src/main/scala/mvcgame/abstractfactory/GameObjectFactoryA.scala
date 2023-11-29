package mvcgame.abstractfactory

import mvcgame.model.gameObjects.AbstractCannon
import mvcgame.model.gameObjects.Cannon
import mvcgame.model.Position
import mvcgame.config.MvcGameConfig
import mvcgame.model.gameObjects.Missile
import mvcgame.model.GameModel
import mvcgame.nullObject.Maybe
import mvcgame.model.gameObjects.AbstractMissile

class GameObjectFactoryA private (var model: GameModel)
    extends GameObjectFactory {
  def createCannon(): AbstractCannon =
    new Cannon(
      new Position(MvcGameConfig.CANNON_POS_X, MvcGameConfig.CANNON_POS_Y),
      this
    );
  def createMissile(): AbstractMissile =
    new Missile(
      new Position(
        model.cannon.pos.dimX,
        model.cannon.pos.dimY
      )
    );
}

object GameObjectFactoryA {
  private var instance: Maybe[GameObjectFactoryA] = Maybe.None

  def apply(model: GameModel): GameObjectFactoryA = instance match {
    case Maybe.None => {
      val i = new GameObjectFactoryA(model)
      instance = Maybe.Some(i)
      i
    }
    case Maybe.Some(i) => i
  }

}
