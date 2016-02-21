package edu.luc.cs.laufer.cs372.shapes

object size {
  def apply(s: Shape): Int = s match {

    case Rectangle(width, height) => 1

    case Ellipse(majorRadius, minorRadius) => 1

    case Location(x, y, shape) => size(shape)

    case Group(shapes @ _*) => shapes.foldLeft(0){_ + size(_)}

    case _ => 0
  }
}