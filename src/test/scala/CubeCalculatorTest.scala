import org.scalatest.funsuite.AnyFunSuite

class CubeCalculatorTest extends AnyFunSuite {
  test("CubeCalculator.cube 3 should be 27") {
    assert(CubeCalculator.cube(3) === 27)
  }

  test("CubeCalculator.cube 0 should be 0") {
    assert(CubeCalculator.cube(0) === 0)
  }

  test("CubeCalculator.cube 5 should be 125") {
    assert(CubeCalculator.cube(5) === 125)
  }

  test("Freddy begins with F") {
    assert(FirstLetter.FirstLetter("Freddy") === 'F')
  }
  test("Hello should start with H") {
    assert("Hello".startsWith("H"))
  }
}