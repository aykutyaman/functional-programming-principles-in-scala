package week2

object rationals {

  class Rational(x: Int, y: Int) {
    require(y != 0, "denominator must be nonzero")

    def this(x: Int) = this(x, 1)

    private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
    val numer = x
    val denom = y

    def < (that: Rational) = this.numer * that.denom < that.numer * this.denom

    def max(that: Rational) = if(this < that) that else this

    def + (that: Rational) =
      new Rational(
        this.numer * that.denom + that.numer * this.denom,
        this.denom * that.denom)

    override def toString = {
      val g = gcd(numer, denom)
      numer / g + "/" + denom / g
    }

    def unary_- : Rational = new Rational(-numer, denom)

    def - (that: Rational) = this + -that // add(that.neg)

  }

}
