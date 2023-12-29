package mvcgame.config

object MvcGameConfig {
  val MAX_X: Int = 1920
  val MAX_Y: Int = 1080

  val MOVE_STEP: Int = 10
  val ANGLE_STEP: Double = Math.PI / 10
  val POWER_STEP: Int = 1

  val INIT_ANGLE: Double = 0
  val INIT_POWER: Int = 10
  val MAX_POWER: Int = 50
  val MIN_POWER: Int = 1

  val CIRCLE_SPEED_MULTIPLIER: Double = 0.25
  val CIRCLE_GROWTH: Double = 1.2
  val CIRCLE_RADIUS: Double = 5
  val CIRCLE_FREQUENCY: Double = 1

  val GRAVITY: Double = 9.81

  val CANNON_POS_X: Int = MAX_X / 5
  val CANNON_POS_Y: Int = MAX_Y / 2

  val GAME_TITLE = "AngryPatterns"

  val UP_KEY = "UP"
  val DOWN_KEY = "DOWN"
  val EXIT_KEY = "ESCAPE"
  val SHOOT_KEY = "SPACE"
  val POWER_UP_KEY = "D"
  val POWER_DOWN_KEY = "A"
  val AIM_UP_KEY = "W"
  val AIM_DOWN_KEY = "S"
  val ADD_MISSILE_KEY = "E"
  val DEL_MISSILE_KEY = "Q"

  val MOVING_STRATEGY_KEY = "M";
  val SHOOTING_MODE_KEY = "N";
  val UNDO_LAST_COMMAND_KEY = "B";

  val CANNON_IMAGE_RESOURCE = "/images/cannon.png"
  val MISSILE_IMAGE_RESOURCE = "/images/missile.png"

  val CANNON_SOUND_RESOURCE = "src/main/resources/sounds/pewpew.m4a"
}
