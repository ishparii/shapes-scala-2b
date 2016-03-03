//package edu.luc.cs.laufer.cs372.shapes
//
//object TestScaledFixtures {
//
//  val simpleEllipseScaledByTwo = Ellipse(100, 60)
//
//  val simpleRectangleScaledByTwo = Rectangle(160, 240)
//
//  val simpleLocationScaledByTwo = Location(140, 60, Rectangle(160, 240))
//
//  val basicGroupScaledByTwo = Group(Ellipse(100, 60), Rectangle(40, 80))
//
//  val simpleGroupScaledByTwo = Group(
//    Location(400, 200, Ellipse(100, 60)),
//    Location(800, 600, Rectangle(200, 100))
//  )
//
//  val complexGroupScaledByTwo =
//    Location(100, 200,
//      Group(
//        Ellipse(40, 80),
//        Location(300, 100,
//          Group(
//            Rectangle(100, 60),
//            Rectangle(600, 120),
//            Location(200, 400,
//              Ellipse(100, 60)
//            )
//          )),
//        Rectangle(200, 400)
//      ))
//}