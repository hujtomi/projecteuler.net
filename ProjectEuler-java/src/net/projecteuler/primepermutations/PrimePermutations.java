package net.projecteuler.primepermutations;

import java.util.LinkedList;

public class PrimePermutations {

	public PrimePermutations() {

		LinkedList<Integer> primes = new LinkedList<Integer>();

		for (int i = 1000; i < 10000; i++) {
			if (isPrime(i))
				primes.add(i);
		}

		for (int i = 0; i < primes.size(); i++) {
			for (int j = i; j < primes.size(); j++) {
				int diff = primes.get(j) - primes.get(i);

				if (diff > 0 && isPrime((int)primes.get(j) + diff) 
						&& Integer.toString(primes.get(j) + diff).length() == 4
						&& containsTheSameDigits(primes.get(i), primes.get(j))
						&& containsTheSameDigits(primes.get(j) + diff, primes.get(j))
						&& containsTheSameDigits(primes.get(j) + diff, primes.get(i))
						) {
					System.out.println(primes.get(i) + " " + primes.get(j) + " " + (primes.get(j) + diff));
				} 
			}
		}

	}

	private static boolean isPrime(int num) {
		if (num % 2 == 0)
			return false;
		for (int i = 3; i * i <= num; i += 2)
			if (num % i == 0)
				return false;
		return true;
	}
	
	public boolean containsTheSameDigits(int num1, int num2) {
		char[] chars1 = Integer.toString(num1).toCharArray();
		char[] chars2 = Integer.toString(num2).toCharArray();
		
		for (char c : chars1) {
			if(!Integer.toString(num2).contains(Character.toString(c)))
				return false;
		}
		
		if(chars1.length == chars2.length)
			return true;
		
		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new PrimePermutations();

	}

}
