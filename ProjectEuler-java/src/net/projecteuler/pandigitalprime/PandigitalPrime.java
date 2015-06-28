package net.projecteuler.pandigitalprime;

public class PandigitalPrime {

	public PandigitalPrime() {
		for (int i = 0; i < 1000000000; i++) {

			if (isPrime(i) && isPandigital(i)) {
				System.out.println(i);
			}
		}
	}

	private boolean isPandigital(int num) {
		boolean pandigital = true;
		int len = Integer.toString(num).length();

		for (int i = 1; i <= len; i++) {
			if (!Integer.toString(num).contains(Integer.toString(i))) {
				pandigital = false;
			}
		}

		return pandigital;
	}

	private static boolean isPrime(int num) {
		if (num % 2 == 0)
			return false;
		for (int i = 3; i * i <= num; i += 2)
			if (num % i == 0)
				return false;
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new PandigitalPrime();

	}

}
