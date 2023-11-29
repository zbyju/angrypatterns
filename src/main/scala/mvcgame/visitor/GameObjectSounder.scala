package mvcgame.visitor

import scalafx.scene.canvas.GraphicsContext
import mvcgame.nullObject.Maybe
import mvcgame.model.gameObjects.AbstractCannon
import mvcgame.model.gameObjects.AbstractMissile
import scalafx.scene.image.Image
import mvcgame.config.MvcGameConfig
import scalafx.scene.media.Media
import scalafx.scene.media.MediaPlayer
import java.io.File

class GameObjectSounder() extends GameObjectVisitor {
  val musicFile = MvcGameConfig.CANNON_SOUND_RESOURCE
  val sound = new Media(new File(musicFile).toURI().toString());

  override def visitCannon(cannon: AbstractCannon): Unit = {
    val mediaPlayer = new MediaPlayer(sound);
    mediaPlayer.play();
  }

  override def visitMissile(missile: AbstractMissile): Unit = {}

}
