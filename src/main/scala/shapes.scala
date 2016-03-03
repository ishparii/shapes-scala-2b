package edu.luc.cs.laufer.cs372.shapes

import scalaz.{ Equal, Functor }
import scalamu._ // algebra types and injected cata method

/**
 * data Shape = Rectangle(w, h) | Location(x, y, Shape)
 */
object structures {

  sealed trait ShapeF[+A]

  case class Rectangle(width: Int, height: Int) extends ShapeF[Nothing] {
    require(width >= 0, "negative width")
    require(height >= 0, "negative height")
  }

  case class Location[A](x: Int, y: Int, shape: A) extends ShapeF[A] {
    require(shape != null, "null shape in location")
  }

  case class Ellipse(majorRadius: Int, minorRadius: Int) extends ShapeF[Nothing] {
    require(majorRadius >= 0, "negative width")
    require(minorRadius >= 0, "negative height")
  }

  case class Group[A](shapes: A*) extends ShapeF[A] {
    require(shapes.nonEmpty, "no shapes in group")
    shapes.foreach((s: A) => require(s != null, "null shape object"))
  }

  /**
    * Implicit value for declaring `ShapeF` as an instance of
    * typeclass `Functor` in scalaz. This requires us to define
    * `map`.
    */
  implicit object shapeFFunctor extends Functor[ShapeF] {
    def map[A, B](fa: ShapeF[A])(f: A => B): ShapeF[B] = fa match {
      case Rectangle(width, height) => Rectangle(width, height)
      case Ellipse(majorRadius, minorRadius) => Ellipse(majorRadius, minorRadius)
      case Location(x, y, shape) => Location(x, y, f(shape))
      case Group(shapes @_*) => Group(shapes.map(f(_)): _*)
    }
  }

  /**
    * Implicit value for declaring `ShapeF` as an instance of
    * scalaz typeclass `Equal` using structural equality.
    * This enables `===` and `assert_===` on `ShapeF` instances.
    */
  implicit def shapeFEqual[A](implicit A: Equal[A]): Equal[ShapeF[A]] = Equal.equal {
    case (Rectangle(width1, height1), Rectangle(width2, height2)) => width1 == width2 && height1 == height2
    case (Ellipse(majorRadius1, minorRadius1), Ellipse(majorRadius2, minorRadius2)) => majorRadius1 == majorRadius2 && minorRadius1 == minorRadius2
    case (Location(x1, y1, shape1), Location(x2, y2, shape2)) => x1 == x2 && y1 == y2 && A.equal(shape1, shape2)
    case (Group(shapes1 @_*), Group(shapes2 @_*)) => shapes1.zip(shapes2).forall{case (shape1, shape2) => A.equal(shape1, shape2)}
  }

  /** Least fixpoint of `ShapeF` as carrier object for the initial algebra. */
  type Shape = µ[ShapeF]

  /** Factory for creating Shape instances. */
  object ShapeFactory {
    def rectangle(width: Int, height: Int) = In[ShapeF](Rectangle(width, height))
    def ellipse(majorRadius: Int, minorRadius: Int) = In[ShapeF](Ellipse(majorRadius, minorRadius))
    def location(x: Int, y: Int, shape: Shape) = In[ShapeF](Location(x, y, shape))
    def group(shapes: Shape*) = In[ShapeF](Group(shapes: _*))
  }

}
