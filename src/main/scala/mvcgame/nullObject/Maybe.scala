package mvcgame.nullObject

import java.{util => ju}

enum Maybe[+A] {
  case Some(value: A)
  case None

  def apply(f: A => Unit): Unit = this match {
    case Some(a) => f(a)
    case None    =>
  }

  def map[B](f: A => B): Maybe[B] = this match {
    case Some(a) => Some(f(a))
    case None    => None
  }

  def flatMap[B](f: A => Maybe[B]): Maybe[B] = this match {
    case Some(a) => f(a)
    case None    => None
  }

  def get: A = this match {
    case Some(a) => a
    case None    => throw ju.NoSuchElementException("None.get")
  }

  def getOrElse[B >: A](default: B): B = this match {
    case Some(a) => a
    case None    => default
  }

  def isEmpty: Boolean = this match {
    case Some(_) => false
    case None    => true
  }

  def isDefined: Boolean = !isEmpty
}

object Maybe {
  def apply[A](obj: A): Maybe[A] = if obj == null then None else Some(obj)
}
