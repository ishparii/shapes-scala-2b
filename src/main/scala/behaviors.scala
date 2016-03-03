
import edu.luc.cs.laufer.cs372.shapes.structures._

import scalamu.Algebra


object behaviors {

  val size: Algebra[ShapeF, Int]= {
    case Rectangle(width, height) => 1
    case Ellipse(majorRadius, minorRadius) => 1
    case Location(x, y, shape) => shape
    case Group(shapes@_*) => shapes.sum
  }


  val depth:Algebra[ShapeF,Int]={
      case Rectangle(width, height)=>1
      case Ellipse(majorRadius, minorRadius)=>1
      case Location(x,y,shape)=> shape+1
     case Group(shapes@_*)=>shapes.max + 1
    }

  //val scale:Algebra[ShapeF,ShapeF]={
    //case Rectangle(width, height)=> Rectangle(width*f, height*f)

  //}

 // val boundingBox:Algebra[ShapeF, Location]={
   // case Rectangle()
  //}



  }




