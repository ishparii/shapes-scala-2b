
import edu.luc.cs.laufer.cs372.shapes.structures
import edu.luc.cs.laufer.cs372.shapes.structures._
import structures.ShapeFactory._
import scalamu.Algebra


object behaviors {

  val size: Algebra[ShapeF, Int] = {
    case Rectangle(width, height) => 1
    case Ellipse(majorRadius, minorRadius) => 1
    case Location(x, y, shape) => shape
    case Group(shapes@_*) => shapes.sum
  }


  val depth: Algebra[ShapeF, Int] = {
    case Rectangle(width, height) => 1
    case Ellipse(majorRadius, minorRadius) => 1
    case Location(x, y, shape) => shape + 1
    case Group(shapes@_*) => shapes.max + 1
  }


  val scale: Int => Algebra[ShapeF, Shape] = f => {
    case Rectangle(width, height) => rectangle(width * f, height * f)
    case Ellipse(majorRadius, minorRadius) => ellipse(majorRadius * f, minorRadius * f)
    case Location(x, y, shape) => location(x * f, y * f, shape)
    case Group(shapes@_*) => group(shapes: _*)


  }

  val boundingBox: Algebra[ShapeF, Location[Rectangle]] = {
    case Rectangle(width, height )=> Location(0, 0, Rectangle(width, height))
    case Ellipse(majorRadius,minorRadius) => Location(-majorRadius, -minorRadius, Rectangle(majorRadius*2, minorRadius*2))
    case Location(x,y,shape) => Location(x+shape.x, y+shape.y, shape.shape)
    case Group(shapes @ _*) => {
      val xList = shapes.flatMap(shape => List(shape.x, shape.x+shape.shape.width))
      val yList = shapes.flatMap(shape => List(shape.y, shape.y+shape.shape.height))
      val xMin = xList.min
      val xMax = xList.max
      val yMin = yList.min
      val yMax = yList.max
      Location(xMin, yMin, Rectangle(xMax-xMin, yMax-yMin))
    }
  }
}








