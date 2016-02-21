package edu.luc.cs.laufer.cs372.shapes

object scale {
  def apply(s: Shape, factor: Int): Shape = s match {

    case Rectangle(width, height) => Rectangle(width/factor, height/factor)

    case Ellipse(majorRadius, minorRadius) => Ellipse(majorRadius/factor, minorRadius/factor)

    case Location(x, y, shape) => Location(x/factor, y/factor, scale(shape,factor))

    case Group(shapes @ _*) => Group(shapes.map(scale(_,factor)):_*)

    case _ => null
  }

}