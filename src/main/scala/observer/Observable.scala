package fit.cvut.cz.mvcgame.observer

import fit.cvut.cz.mvcgame.observer.Observer

trait Observable {
  val observers = scala.collection.mutable.ArrayBuffer[Observer]()

  def registerObserver(observer: Observer): Unit
  def unregisterObserver(observer: Observer): Unit
  def notifyObservers(): Unit
}
