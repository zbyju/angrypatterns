import mvcgame.MvcGame
import scalafx.Includes._
import scalafx.scene.Group
import scalafx.application.JFXApp3
import scalafx.application.JFXApp3.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.canvas.Canvas
import scalafx.scene.input.{KeyCode, KeyEvent}
import scalafx.scene.layout.StackPane
import scalafx.animation.AnimationTimer
import scalafx.scene.paint.Color
import mvcgame.config.MvcGameConfig
import mvcgame.bridge.{ScalaFxGraphics, GameGraphics}

object GameScalaFxLauncher extends JFXApp3 {

  val theMvcGame = new MvcGame()
  val winTitle = MvcGameConfig.GAME_TITLE
  val winWidth = MvcGameConfig.MAX_X
  val winHeight = MvcGameConfig.MAX_Y

  override def start(): Unit = {
    stage = new PrimaryStage {
      title = winTitle
      scene = new Scene(winWidth, winHeight) {
        val canvas = new Canvas(winWidth, winHeight)
        val gameGraphics = new GameGraphics(
          new ScalaFxGraphics(canvas.graphicsContext2D)
        )
        val pressedKeysCodes = scala.collection.mutable.ArrayBuffer[String]()

        onKeyPressed = (e: KeyEvent) => {
          val code = e.getCode.toString
          if (!pressedKeysCodes.contains(code))
            pressedKeysCodes += code
        }

        onKeyReleased = (e: KeyEvent) => {
          val code = e.getCode
          pressedKeysCodes -= code.toString
        }

        root = new StackPane {
          children = new Group(canvas)
        }

        theMvcGame.setGameGraphics(gameGraphics)

        val timer: AnimationTimer = AnimationTimer(t => {
          theMvcGame.processPressedKeys(pressedKeysCodes)
        })
        timer.start()
      }
    }
  }
}
