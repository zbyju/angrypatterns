package mvcgame.abstractfactory

import mvcgame.model.gameObjects.AbstractCannon
import mvcgame.model.gameObjects.Cannon
import mvcgame.model.Position
import mvcgame.config.MvcGameConfig
import mvcgame.model.gameObjects.Missile
import mvcgame.model.GameModel
import mvcgame.nullObject.Maybe
import mvcgame.model.gameObjects.AbstractMissile

object GameObjectFactoryA extends GameObjectFactory {
  private var model: Maybe[GameModel] = Maybe.None

  def apply(m: GameModel): GameObjectFactory = {
    model = Maybe(m)
    this
  }

  def createCannon(): AbstractCannon =
    new Cannon(
      new Position(MvcGameConfig.CANNON_POS_X, MvcGameConfig.CANNON_POS_Y),
      this
    );
  def createMissile(): AbstractMissile =
    new Missile(
      new Position(
        model.map(_.cannon.pos.dimX).getOrElse(0),
        model.map(_.cannon.pos.dimY).getOrElse(0)
      )
    );

}
