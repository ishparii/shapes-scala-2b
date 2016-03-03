//package edu.luc.cs.laufer.cs372.shapes
//
//object boundingBox {
//  def apply(s: Shape): Location = s match {
//
//    case Rectangle(width, height) => Location(0, 0, Rectangle(width, height))
//
//    case Ellipse(majorRadius, minorRadius) => Location(-majorRadius, -minorRadius, Rectangle(majorRadius*2, minorRadius*2))
//
//    case Location(x, y, shape) => {
//      val loc = boundingBox(shape)
//      Location(x+loc.x, y+loc.y, loc.shape)
//    }
//
//    case Group(shapes @ _*) => {
//
//      val xList = shapes.flatMap(shape => {
//        val loc = boundingBox(shape)
//        List(loc.x, loc.x+loc.shape.asInstanceOf[Rectangle].width)
//      })
//
//      val yList = shapes.flatMap(shape => {
//        val loc = boundingBox(shape)
//        List(loc.y, loc.y+loc.shape.asInstanceOf[Rectangle].height)
//      })
//
//      val xMin = xList.min
//      val xMax = xList.max
//      val yMin = yList.min
//      val yMax = yList.max
//
//      Location(xMin, yMin, Rectangle(xMax-xMin, yMax-yMin))
//    }
//
//    case _ => Location(0, 0, Rectangle(0, 0)) // to catch all other cases
//  }
//}
