import org.scalatest.FunSuite
import week2.fixedPoint._

class fixedPointSuite extends FunSuite {

  test("fixedPoint") {
    val p1 = fixedPoint(x => 1 + x/2)(1)
    assert(p1 === 1.999755859375)
    println(sqrt(16))
  }

}
