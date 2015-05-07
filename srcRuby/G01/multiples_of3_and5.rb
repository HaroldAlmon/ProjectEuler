def calculate_sum_below_limit(upper_limit, k)
  # This is a variation of the sum(1..n) formula.
  #
  # Sum(1...kn) = k * n * (n + 1)
  #                   -----------
  #                        2
  # Also the formula includes n, the problem does not.
  n = (upper_limit-1)/k
  result = k * n * (n + 1) / 2
end

sum_of_multiples = 0
upper_limit = 1000
sum_of_multiples += calculate_sum_below_limit(upper_limit, 3)
sum_of_multiples += calculate_sum_below_limit(upper_limit, 5)
sum_of_multiples -= calculate_sum_below_limit(upper_limit, 15)
puts "sum_of_multiples(1000) = #{sum_of_multiples}"
