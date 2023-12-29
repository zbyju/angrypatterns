package mvcgame.abstractfactory

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import mvcgame.view.GameView
import mvcgame.model.GameModel
import mvcgame.observer.CannonMoved
import scala.util.Try

class GameObjectFactoryATest extends AnyFlatSpec with Matchers {
  "GameObjectFactoryA" should "always just create one instance" in {
    val model = GameModel()
    val i1 = GameObjectFactoryA(model)
    val i2 = GameObjectFactoryA(model)
    assert(i1.hashCode() == i2.hashCode())
  }
}
