package edu.luc.cs.laufer.cs372.shapes
import structures.ShapeFactory._

object TestScaledFixtures {

  val simpleEllipseScaledByTwo = ellipse(100, 60)

  val simpleRectangleScaledByTwo = rectangle(160, 240)

  val simpleLocationScaledByTwo = location(140, 60, rectangle(160, 240))

  val basicGroupScaledByTwo = group(ellipse(100, 60), rectangle(40, 80))

  val simpleGroupScaledByTwo = group(
    location(400, 200, ellipse(100, 60)),
    location(800, 600, rectangle(200, 100))
  )

  val complexGroupScaledByTwo =
    location(100, 200,
      group(
        ellipse(40, 80),
        location(300, 100,
          group(
            rectangle(100, 60),
            rectangle(600, 120),
            location(200, 400,
              ellipse(100, 60)
            )
          )),
        rectangle(200, 400)
      ))
}