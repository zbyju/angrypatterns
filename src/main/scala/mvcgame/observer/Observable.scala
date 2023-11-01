package mvcgame.observer

import scala.collection.mutable.{Map, Set}

trait Observable {
  protected val observers = Map[Aspect, Set[Observer]]()

  def subscribe(observer: Observer, aspect: Aspect): Unit =
    println(observers)
    observers += (aspect -> (observers.getOrElse(aspect, Set()) + observer))
    println(observers)

  def unsubscribe(observer: Observer, aspect: Aspect): Unit = {
    println(observers)
    val aspectObservers = observers.getOrElse(aspect, Set())
    val updatedObservers = aspectObservers - observer
    if (updatedObservers.isEmpty) {
      observers -= aspect
    } else {
      observers += (aspect -> updatedObservers)
    }
    println(observers)
  }

  def notifyObservers(aspect: Aspect): Unit = {
    observers
      .getOrElse(aspect, Set())
      .foreach(observer => observer.update(aspect))
  }
}
