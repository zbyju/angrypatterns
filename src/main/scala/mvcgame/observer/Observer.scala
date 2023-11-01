package mvcgame.observer

trait Observer {
  def update(aspect: Aspect): Unit
}
