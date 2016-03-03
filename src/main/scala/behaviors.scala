
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

  val boundingBox: Algebra[ShapeF, Shape] = {
    case Rectangle(width, height)=> location(0,0, rectangle(width,height))
    case Ellipse(minorRadius,majorRadius)=> location(-minorRadius,-majorRadius, rectangle(2*minorRadius,2*majorRadius))
    case Location(x,y,shape)=>
      {
        val loc=shape.asInstanceOf[Location]
        location(x+loc.x,y+loc.y,shape)
      }


  }
}








