package week2

import org.scalatest.FunSuite
import FunSets._

class FunSetsSuite extends FunSuite {

  test("contains is implemented") {
    assert(contains(x => x > 0, 100))
  }

  /**
   * When writing tests, one would often like to re-use certain values for multiple
   * tests. For instance, we would like to create an Int-set and have multiple test
   * about it.
   *
   * Instead of copy-pasting the code for creating the set into every test, we can
   * store it in the test class using a val:
   *
   *   val s1 = singletonSet(1)
   *
   * However, what happens if the method "singletonSet" has a bug and crashes? Then
   * the test methods are not even executed, because creating an instance of the
   * test class fails!
   *
   * Therefore, we put the shared values into a separate trait (traits are like
   * abstract classes), and create an instance inside each test method.
   *
   */

  trait TestSets {
    val s1 = singletonSet(1)
    val s2 = singletonSet(2)
    val s3 = singletonSet(3)
    val s4 = singletonSet(3)
  }

  /**
   * This test is currently disabled (by using "ignore") because the method
   * "singletonSet" is not yet implemented and the test would fail.
   *
   * Once you finish your implementation of "singletonSet", exchange the
   * function "ignore" by "test".
   */
  test("singletonSet(1) contains 1") {

    /**
     * We create a new instance of the "TestSets" trait, this gives us access
     * to the values "s1" to "s3".
     */
    new TestSets {
      assert(contains(s1, 1), "Singleton")
      assert(contains(s2, 2), "Singleton")
      assert(contains(s3, 3), "Singleton")
      assert(contains(s1, 2) === false, "Singleton")
    }
  }

  test("union contains all elements of each set") {
    new TestSets {
      val s = union(s1, s2)
      assert(contains(s, 1), "Union 1")
      assert(contains(s, 2), "Union 2")
      assert(!contains(s, 3), "Union 3")
    }
  }

  test("intersection") {
    new TestSets {
      val s = intersect(s3, s4)
      assert(contains(s, 3), "Intersection")
    }
  }

  test("diff") {
    new TestSets {
      val s = diff(s1, s2)
      assert(contains(s, 1), "diff")
    }
  }

  test("filter") {
    new TestSets {
      val s = filter(s1, (x) => x > 0)
      assert(!contains(s, 3))
      assert(contains(s, 1))
    }
  }

  test("forall") {
    new TestSets {
      val s = union(s1, s2)
      assert(forall(s, x => x < 3))
    }
  }

  test("exists") {
    new TestSets {
      assert(exists(s1, x => x < 2 && x > 0))
    }
  }

  test("map") {
    new TestSets {
      val s = map(s3, x => x * 20)
      assert(contains(s, 60))
    }
  }

}
