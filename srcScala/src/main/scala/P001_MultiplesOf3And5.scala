object P001_MultiplesOf3And5 extends App{
  println(multiplesOf3And5(1000))

  private def multiplesOf3And5(upperLimit: Int) = {
    var MultiplesSum = 0
    MultiplesSum += calculateSumBelowLimit(upperLimit, 3 )
    MultiplesSum += calculateSumBelowLimit(upperLimit, 5)
    MultiplesSum -= calculateSumBelowLimit(upperLimit, 15)
    MultiplesSum
  }

  // This is a variation of the sum(1..n) formula.
  //
  // Sum(1...kn) = k * n * (n + 1)
  //                   -----------
  //                        2
  // The formula includes n, the problem does not.
  private def calculateSumBelowLimit(upperLimit: Int, divisor: Int) = {
    val n = (upperLimit - 1) / divisor
    divisor * n * (n + 1) / 2
  }
}