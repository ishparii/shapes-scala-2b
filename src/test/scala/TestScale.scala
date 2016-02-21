/**
  * Created by Ilona on 2/20/2016.
  */
package edu.luc.cs.laufer.cs372.shapes

import org.scalatest.FunSuite

import TestFixtures._
//import TestScaledFixtures._

class TestScale extends FunSuite {
  def testScale(description: String, s: Shape, factor: Int, newShape: Shape) {
    test(description){
        assert(scale(s, factor) === newShape)
    }
  }

//  testScale("simple ellipse", simpleEllipse, simpleEllipse)
//  testScale("simple rectangle", simpleRectangle, 1)
//  testScale("simple location", simpleLocation, 1)
//  testScale("basic group", basicGroup, 2)
//  testScale("simple group", simpleGroup, 2)
//  testScale("complex group", complexGroup, 5)
}
