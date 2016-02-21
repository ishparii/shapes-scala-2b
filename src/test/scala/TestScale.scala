/**
  * Created by Ilona on 2/20/2016.
  */
package edu.luc.cs.laufer.cs372.shapes

import org.scalatest.FunSuite

import TestFixtures._
import TestScaledFixtures._

class TestScale extends FunSuite {
  def testScale(description: String, s: Shape, factor: Int, newShape: Shape) {
    test(description){
      val scaled = scale(s, factor)
      s match {
        case Rectangle(width, height) => {
          assert(scale(s, factor).asInstanceOf[Rectangle].width === newShape.asInstanceOf[Rectangle].width)
          assert(scale(s, factor).asInstanceOf[Rectangle].height === newShape.asInstanceOf[Rectangle].height)
        }

        case Ellipse(majorRadius, minorRadius) => {
          assert(scale(s, factor).asInstanceOf[Ellipse].majorRadius === newShape.asInstanceOf[Ellipse].majorRadius)
          assert(scale(s, factor).asInstanceOf[Ellipse].minorRadius === newShape.asInstanceOf[Ellipse].minorRadius)
        }

        case Location(x, y, shape) => {
          assert(scale(s, factor).asInstanceOf[Location].x === newShape.asInstanceOf[Location].x)
          assert(scale(s, factor).asInstanceOf[Location].y === newShape.asInstanceOf[Location].y)
          testScale("location shape", shape, factor, newShape.asInstanceOf[Location].shape)
        }

        case Group(shapes @ _*) => {
          val newShapes = newShape.asInstanceOf[Group].shapes
          (shapes, newShapes).zipped.map(testScale("group shape", _, factor, _))
        }
        case _ => assert(scale(s, factor) === newShape)
      }
    }
  }

  testScale("simple ellipse", simpleEllipse, 2, simpleEllipseScaledByTwo)
  testScale("simple rectangle", simpleRectangle, 2, simpleRectangleScaledByTwo)
  testScale("simple location", simpleLocation, 2, simpleLocationScaledByTwo)
  testScale("basic group", basicGroup, 2, basicGroupScaledByTwo)
  testScale("simple group", simpleGroup, 2, simpleGroupScaledByTwo)
  testScale("complex group", complexGroup, 2, complexGroupScaledByTwo)
}
