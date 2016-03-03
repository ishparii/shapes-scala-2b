///**
//  * Created by Ilona on 2/20/2016.
//  */
//package edu.luc.cs.laufer.cs372.shapes
//
//import org.scalatest.FunSuite
//
//import TestFixtures._
//import TestScaledFixtures._
//
//class TestScale extends FunSuite {
//  def testScale(description: String, s: Shape, factor: Int, newShape: Shape) {
//    test(description){
//      assert(scale(s, factor) === newShape)
//    }
//  }
//
//  testScale("simple ellipse", simpleEllipse, 2, simpleEllipseScaledByTwo)
//  testScale("simple rectangle", simpleRectangle, 2, simpleRectangleScaledByTwo)
//  testScale("simple location", simpleLocation, 2, simpleLocationScaledByTwo)
//  testScale("basic group", basicGroup, 2, basicGroupScaledByTwo)
//  testScale("simple group", simpleGroup, 2, simpleGroupScaledByTwo)
//  testScale("complex group", complexGroup, 2, complexGroupScaledByTwo)
//}
