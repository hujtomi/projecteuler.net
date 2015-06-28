package net.projecteuler.largenonmersenneprime;


public class LargeNonMersennePrime {

	public LargeNonMersennePrime() {
		
		long pow = 2;
		for (int i = 0; i < (7830457 - 1); i++) {
			pow *= 2;
			pow %= 10000000000l;
		}
		
		pow *= 28433;
		pow++;
		
		System.out.println(Long.toString(pow));

	}

	public static void main(String[] args) {
		new LargeNonMersennePrime();

	}
}
