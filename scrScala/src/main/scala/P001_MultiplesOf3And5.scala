/**
 * Created by Harold on 6/27/2015.
 */
/*object P001_MultiplesOf3And5 extends App {
  println("Hello")
}*/

object P000_MultiplesOf3And5 extends App{
  println(multiplesOf3And5(1000))

  def multiplesOf3And5(upperLimit: Int): Int = {
    var MultiplesSum: Int = 0
    MultiplesSum += calculateSumBelowLimit( upperLimit, 3 )
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
  def calculateSumBelowLimit(upperLimit: Int, divisor: Int): Int = {
    var result = 0

    val n = (upperLimit - 1) / divisor
    divisor * n * (n + 1) / 2
  }
}