import org.scalatest.FunSuite
import week1.exercise._

class exerciseSuite extends FunSuite {
  test("factorial") {
    assert(factorial(1) == 1)
    assert(factorial(2) == 2)
    assert(factorial(3) == 6)
    assert(factorial(4) == 24)
  }
}
