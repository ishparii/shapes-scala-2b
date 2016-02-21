/**
  * Created by Ilona on 2/20/2016.
  */
package edu.luc.cs.laufer.cs372.shapes

import org.scalatest.FunSuite

import TestFixtures._

class TestDepth extends FunSuite {

  def testDepth(description: String, s: Shape, n: Int) = {
    test(description) {
      assert(n === depth(s))
    }
  }

  testDepth("simple ellipse", simpleEllipse, 1)
  testDepth("simple rectangle", simpleRectangle, 1)
  testDepth("simple location", simpleLocation, 2)
  testDepth("basic group", basicGroup, 2)
  testDepth("simple group", simpleGroup, 3)
  testDepth("complex group", complexGroup, 6)

}
