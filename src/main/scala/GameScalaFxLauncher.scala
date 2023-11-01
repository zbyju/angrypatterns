package fit.cvut.cz

import fit.cvut.cz.mvcgame.MvcGame
/*
import scalafx.application.JFXApp3
import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.effect.DropShadow
import scalafx.scene.layout.HBox
import scalafx.scene.paint.Color._
import scalafx.scene.paint._
import scalafx.scene.text.Text
import scalafx.scene.canvas.Canvas
import scala.collection.mutable.ArrayBuffer
import javafx.animation.AnimationTimer
 */
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
import fit.cvut.cz.mvcgame.config.MvcGameConfig

object GameScalaFxLauncher extends JFXApp3 {

  val winTitle = MvcGameConfig.GAME_TITLE
  val winWidth = MvcGameConfig.MAX_X
  val winHeight = MvcGameConfig.MAX_Y

  override def start(): Unit = {
    stage = new PrimaryStage {
      title = winTitle
      scene = new Scene(winWidth, winHeight) {
        val canvas = new Canvas(winWidth, winHeight)
        val gc = canvas.graphicsContext2D
        val pressedKeysCodes = scala.collection.mutable.ArrayBuffer[String]()

        onKeyPressed = (e: KeyEvent) => {
          val code = e.getCode.toString
          // only add once... prevent duplicates
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

        println("mvcgame1")
        val theMvcGame = new MvcGame(gc)

        val timer: AnimationTimer = AnimationTimer(t => {
          theMvcGame.processPressedKeys(pressedKeysCodes)
        })
        timer.start()
      }
    }
  }
}
