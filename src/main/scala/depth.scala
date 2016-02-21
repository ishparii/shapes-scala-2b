package edu.luc.cs.laufer.cs372.shapes

object depth {
  def apply(s: Shape): Int = s match {

    case Rectangle(width, height) => 1

    case Ellipse(majorRadius, minorRadius) => 1

    case Location(x, y, shape) => depth(shape) + 1

    case Group(shapes @ _*) => shapes.map(depth(_)).max + 1

    case _ => 0
  }

}