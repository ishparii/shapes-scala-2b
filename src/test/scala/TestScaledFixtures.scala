package edu.luc.cs.laufer.cs372.shapes

object TestScaledFixtures {

  val simpleEllipseScaledByTwo = Ellipse(25, 15)

  val simpleRectangleScaledByTwo = Rectangle(40, 60)

  val simpleLocationScaledByTwo = Location(35, 15, Rectangle(40, 60))

  val basicGroupScaledByTwo = Group(Ellipse(25, 15), Rectangle(10, 20))

  val simpleGroupScaledByTwo = Group(
    Location(100, 50, Ellipse(25, 15)),
    Location(200, 150, Rectangle(50, 25))
  )

  val complexGroupScaledByTwo =
    Location(25, 50,
      Group(
        Ellipse(10, 20),
        Location(75, 25,
          Group(
            Rectangle(25, 15),
            Rectangle(150, 30),
            Location(50, 100,
              Ellipse(25, 15)
            )
          )),
        Rectangle(50, 100)
      ))
}