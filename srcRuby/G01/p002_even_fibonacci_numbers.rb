# Strategy: Simple mathematics.

def sum_of_even_fibonacci_numbers(upper_limit)
  even_fibonacci_numbers_sum = 2
  fibo1 = 1
  fibo2 = 2
  next_fibo = 3

  # Use a loop since we do not know the term
  # of the Fibonacci number we are seeking.
  while next_fibo < upper_limit do
    if is_even(next_fibo) then
       even_fibonacci_numbers_sum += next_fibo
    end

    fibo1 = fibo2
    fibo2 = next_fibo
    next_fibo = fibo1 + fibo2
  end

  even_fibonacci_numbers_sum
end

def is_even(n)
  return n % 2 == 0
end

puts "Sum of even fibonacci numbers = #{sum_of_even_fibonacci_numbers(4_000_000)}"
