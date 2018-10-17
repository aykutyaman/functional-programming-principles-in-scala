import org.scalatest.FunSuite
import week2.rationals._

class rationalsSuite extends FunSuite {

  test("instantiate") {
    val x = new Rational(1, 2)
    assert(x.numer == 1)
    assert(x.denom == 2)
  }

  test("addition") {
    val x = new Rational(1, 2)
    val y = new Rational(2, 3);
    assert((x + y).toString == "7/6")
  }

  test("multiple addition") {
    val x = new Rational(1, 2)
    val y = new Rational(5, 7);
    val z = new Rational(3, 2);
    assert(((x + y) + z).toString == "19/7")
  }

  test("negate") {
    val x = new Rational(3, 4)
    assert((-x).toString == "-3/4")
  }

  test("subtract") {
    val x = new Rational(3, 2)
    val y = new Rational(4, 5)
    assert((x - y).toString == "7/10")
  }

  test("multiple substractions") {
    val x = new Rational(1, 3)
    val y = new Rational(5, 7)
    val z = new Rational(3, 2)
    assert((x - y - z).toString == "-79/42")
  }

  test("add itself") {
    val x = new Rational(5, 7)
    assert((x + x).toString == "10/7")
  }

  test("less") {
    val x = new Rational(5, 7)
    val y = new Rational(7, 5)
    assert(x < y == true)
    assert(y < x == false)
  }

  test("max") {
    val x = new Rational(5, 7)
    val y = new Rational(7, 5)
    assert((x max y).toString == "7/5")
  }

  test("illegal rational") {
    intercept[IllegalArgumentException] {
      val x = new Rational(1, 0)
    }
  }

  test("omit denominator") {
    val x = new Rational(2)
    assert(x.toString == "2/1")
  }

  test("simplification made with toString") {
    val x = new Rational(4, 16)
    assert(x.numer == 4)
    assert(x.denom == 16)
    assert(x.toString == "1/4")
  }
}
