package mvcgame.visitor

trait Visitable {
  def acceptVisitor(visitor: GameObjectVisitor): Unit;
}
