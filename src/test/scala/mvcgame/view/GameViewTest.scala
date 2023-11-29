package mvcgame.view

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import mvcgame.view.GameView
import mvcgame.model.GameModel
import mvcgame.observer.CannonMoved
import scala.util.Try

// Create a test class that extends AnyFlatSpec and Matchers
class GameViewTest extends AnyFlatSpec with Matchers {
  "GameView" should "not throw an exception when GraphicsContext is null" in {
    val view = GameView(GameModel())
    val result = Try(view.update(CannonMoved))

    assert(result.isSuccess)
  }
}
