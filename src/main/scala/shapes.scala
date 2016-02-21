package edu.luc.cs.laufer.cs372.shapes

/**
 * data Shape = Rectangle(w, h) | Location(x, y, Shape)
 */
sealed trait Shape

case class Rectangle(width: Int, height: Int) extends Shape {
  require(width>=0, "negative width")
  require(height>=0, "negative height")
}

case class Location(x: Int, y: Int, shape: Shape) extends Shape {
  require(shape != null, "null shape in location")
}

case class Ellipse(majorRadius: Int, minorRadius: Int) extends Shape {
  require(majorRadius>=0, "negative width")
  require(minorRadius>=0, "negative height")
}

case class Group(shapes: Shape*) extends Shape {
  require(shapes.nonEmpty, "no shapes in group")
  shapes.foreach((s:Shape) => require(s != null, "null shape object"))
}

// TODO add missing case classes (see test fixtures)
// TODO must include validity checking for constructor arguments
