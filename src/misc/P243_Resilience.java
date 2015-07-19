package misc;
import divisors;

// Find the smallest denominator d, having a resilience R(d) < 15499/94744
public class P243_Resilience {
	function getResilience() begin 
		int upperLimit = 15499;
		int candidate = 94744
		set numeratorDivisors
		set denomiatorDivisors
		while true do
			denomiatorDivisors = calculateDivisors(candidate)
			
			for i=2 to candidate
				numeratorDivisors = calculateDivisors(i)
				boolean proper = true

				foreach divisor in numeratorDivisors
					if denomiatorDivisors contains(divisor)
						proper = false
					end if
				end

				if proper = true
					total += 1
					
				// Too many
				if total >= upperLimit then
					break;
			end for
			
			
			if total < upperLimit then
				break
			end if
	
			candidate += 1
		end while
	end function
}
