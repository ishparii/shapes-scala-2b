
import edu.luc.cs.laufer.cs372.TestFixtures
import edu.luc.cs.laufer.cs372.shapes.structures.{ShapeF, Rectangle, Location}
import edu.luc.cs.laufer.cs372.shapes.TestScaledFixtures
import org.scalatest.FunSuite
import scalaz.syntax.equal._
import scalaz.std.anyVal._ // for assert_=== to work on Int


class TestBehaviors extends FunSuite {

  import scalamu._
  import behaviors._

  test("size works") {
    TestFixtures.simpleRectangle cata size assert_=== 1
    TestFixtures.simpleEllipse cata size assert_=== 1
    TestFixtures.simpleLocation cata size assert_===1
    TestFixtures.simpleGroup cata size assert_===2
    TestFixtures.basicGroup cata size assert_===2
    TestFixtures.complexGroup cata size assert_===5

  }

  test ("depth works") {
    TestFixtures.simpleEllipse cata depth assert_===1
    TestFixtures.simpleEllipse cata depth assert_===1
    TestFixtures.simpleLocation cata depth assert_===2
    TestFixtures.basicGroup cata depth assert_===2
    TestFixtures.simpleGroup cata depth assert_===3
    TestFixtures.complexGroup cata depth assert_===6


  }

  test ("scale works"){
    TestFixtures.simpleEllipse cata scale (2) assert_===TestScaledFixtures.simpleEllipseScaledByTwo
    TestFixtures.simpleRectangle cata scale (2) assert_===TestScaledFixtures.simpleRectangleScaledByTwo
    TestFixtures.simpleLocation cata scale (2) assert_===TestScaledFixtures.simpleLocationScaledByTwo
    TestFixtures.basicGroup cata scale (2) assert_===TestScaledFixtures.basicGroupScaledByTwo
    TestFixtures.simpleGroup cata scale (2) assert_===TestScaledFixtures.simpleGroupScaledByTwo
    TestFixtures.complexGroup cata scale (2) assert_===TestScaledFixtures.complexGroupScaledByTwo

  }

  test ("boundingBox works"){
    //build a wrapper for convenience
    def w(v: Location[Rectangle]): ShapeF[ShapeF[Unit]] = v
    w(TestFixtures.simpleEllipse cata boundingBox) assert_=== w(Location(-50,-30,Rectangle(100,60)))
    w(TestFixtures.simpleRectangle cata boundingBox) assert_=== w(Location(0,0,Rectangle(80,120)))
    w(TestFixtures.simpleLocation cata boundingBox) assert_=== w(Location(70,30,Rectangle(80,120)))
    w(TestFixtures.basicGroup cata boundingBox) assert_=== w(Location(-50, -30, Rectangle(100, 70)))
    w(TestFixtures.simpleGroup cata boundingBox) assert_=== w(Location(150, 70, Rectangle(350, 280)))
    w(TestFixtures.complexGroup cata boundingBox) assert_=== w(Location(30, 60, Rectangle(470, 320)))
  }
}