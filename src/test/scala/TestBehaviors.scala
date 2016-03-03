
import edu.luc.cs.laufer.cs372.TestFixtures
import org.scalatest.FunSuite
import scalaz.syntax.equal._
import scalaz.std.anyVal._ // for assert_=== to work on Int
//import scalaz.std.option._ // for assert_=== to work on Option

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
}