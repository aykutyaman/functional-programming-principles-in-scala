import org.scalatest.FunSuite
import scala.math.{rint}
import week1.session._

class sessionSuite extends FunSuite {

  test("sqrtIter") {
    assert(sqrt(4) == 2.000609756097561)
    assert(sqrt(16) == 4.000000636692939)
    assert(sqrt(1e-6) == 0.0010000001533016628)
    assert(sqrt(1e60) == 1.0000788456669446E30)
  }
}
