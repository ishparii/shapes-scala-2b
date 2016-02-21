package edu.luc.cs.laufer.cs372.shapes

// TODO: implement this behavior

object boundingBox {
  def apply(s: Shape): Location = s match {

    case Rectangle(width, height) => Location(0, 0, Rectangle(width, height))

    case Ellipse(majorRadius, minorRadius) => Location(-majorRadius, -minorRadius, Rectangle(majorRadius*2, minorRadius*2))

    case Location(x, y, shape) => {
      val loc = apply(shape)
      Location(x+loc.x, y+loc.y, loc.shape)
    }

    case Group(shapes @ _*) => {
//      def getMinAndMax(shape:Shape):(Int, Int) = {
//        val loc = apply(shape)
//        (loc.x, )
//      }
//      var xList = List[Int]()
//      var yList = List[Int]()
//      shapes.foreach(f = (shape: Shape) => {
//        val box = apply(shape)
//        xList = xList :+ box.x
//        xList = xList :+ box.x + box.shape.asInstanceOf[Rectangle].width
//        yList = yList :+ box.y
//        yList = yList :+ box.y + box.shape.asInstanceOf[Rectangle].height
//      } )

      val xList = shapes.flatMap(shape => {
        val loc = apply(shape)
        List(loc.x, loc.x+loc.shape.asInstanceOf[Rectangle].width)
      })
      val yList = shapes.flatMap(shape => {
        val loc = apply(shape)
        List(loc.y, loc.y+loc.shape.asInstanceOf[Rectangle].height)
      })

      val xMin = xList.min
      val xMax = xList.max
      val yMin = yList.min
      val yMax = yList.max
      Location(xMin, yMin, Rectangle(xMax-xMin, yMax-yMin))
    }

    case _ => Location(0, 0, Rectangle(0, 0)) // to catch all other cases
  }
}
