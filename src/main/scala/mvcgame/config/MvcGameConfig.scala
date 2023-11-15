package mvcgame.config

object MvcGameConfig {
  val MAX_X: Int = 1920
  val MAX_Y: Int = 1080
  val MOVE_STEP: Int = 10
  val CANNON_POS_X: Int = MAX_X / 5
  val CANNON_POS_Y: Int = MAX_Y / 2

  val GAME_TITLE = "AngryPatterns"

  val UP_KEY = "UP"
  val DOWN_KEY = "DOWN"
  val EXIT_KEY = "ESCAPE"
  val SHOOT_KEY = "SPACE"

  val CANNON_IMAGE_RESOURCE = "/images/cannon.png"
  val MISSILE_IMAGE_RESOURCE = "/images/missile.png"

  val CANNON_SOUND_RESOURCE = "src/main/resources/sounds/pewpew.m4a"
}
