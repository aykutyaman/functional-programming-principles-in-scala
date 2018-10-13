package week2

object exercise {
  // tail call optimized sum
  def _sum(f: Int => Int)(a: Int, b: Int): Int = {
    def loop(a: Int, acc: Int): Int =
      if (a > b) acc
      else loop(a + 1, f(a) + acc)
    loop(a, 0)
  }

  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int =
    if (a > b) zero
    else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))

  def sum(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x + y, 0)(a, b)
  def product(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x * y, 1)(a, b)

  def factorial(a: Int): Int = product(x => x)(1, a)

  def sumInts(x: Int, y: Int): Int = sum(x => x)(x, y)
  def sumSquares(x: Int, y: Int): Int = sum(x => x * x)(x, y)
  def sumCubes(x: Int, y: Int): Int = sum(x => x * x * x)(x, y)
  def sumFactorials(x: Int, y: Int): Int = sum(factorial)(x, y)

  def productInts(x: Int, y: Int): Int = product(x => x)(x, y)
  def productSquares(x: Int, y: Int): Int = product(x => x * x)(x, y)
  def productCubes(x: Int, y: Int): Int = product(x => x * x * x)(x, y)
  def productFactorials(x: Int, y: Int): Int = product(factorial)(x, y)
}
