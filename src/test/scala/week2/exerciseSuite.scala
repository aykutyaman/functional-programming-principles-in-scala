import org.scalatest.FunSuite
import week2.exercise._

class exerciseSuiteWeek2 extends FunSuite {

  test("sum") {
    assert(sum(x => x)(1, 4) == 10)
    assert(sum(x => x)(1, 7) == 28)
  }

  test("sumInts") {
    assert(sumInts(1, 3) == 6)
    assert(sumInts(3, 5) == 12)
  }

  test("sumCubes") {
    assert(sumCubes(1, 3) == 36)
    assert(sum(x => x * x * x)(1, 3) == 36)
  }

  test("sumSquares") {
    assert(sumSquares(1, 3) == 14)
  }

  test("sumFactorials") {
    assert(sumFactorials(1, 3) == 9)
  }

  test("product") {
    assert(product(x => x)(1, 3) == 6)
    assert(product(x => x * x)(3, 4) == 144)
    assert(product(x => x * x * x)(2, 3) == 216)
    assert(product(factorial)(2, 4) == 288)
  }

  test("products") {
    assert(productInts(1, 3) == 6)
    assert(productSquares(3, 4) == 144)
    assert(productCubes(2, 3) == 216)
    assert(productFactorials(2, 4) == 288)
  }

  test("factorial") {
    assert(factorial(3) == 6)
  }
}
