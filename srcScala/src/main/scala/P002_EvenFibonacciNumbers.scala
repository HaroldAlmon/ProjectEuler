object P002_EvenFibonacciNumbers extends App {
  println(EvenFiboNumbersSum(4000000))

 // public class P002_EvenFibonacciNumbers {
    def EvenFiboNumbersSum(upperLimit: Int) = {
      var EvenFiboNumbersSum = 2
      var fibo1 = 1
      var fibo2 = 2
      var nextFibo = 3

      /* Use a loop since we do not know the term
       * of the Fibonacci number we are seeking. */
      while (nextFibo < upperLimit) {
        var isEven = false

        isEven = (nextFibo % 2 == 0)
        if( isEven ) {
          EvenFiboNumbersSum += nextFibo
        }
        fibo1 = fibo2
        fibo2 = nextFibo
        nextFibo = fibo1 + fibo2
      }
      EvenFiboNumbersSum
    }
}
