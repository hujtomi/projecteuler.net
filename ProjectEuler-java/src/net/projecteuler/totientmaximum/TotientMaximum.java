package net.projecteuler.totientmaximum;

public class TotientMaximum {

	public TotientMaximum() {
		double max = Double.MIN_VALUE;
		
		for (int n = 3; n <= 1000000; n++) {

//			if(n % 10000 == 0)
//				System.out.println(n);
			
			int fin = 1;

			for (int i = 2; i < n; i++) {

				boolean divisorFound = false;
				for (int j = 2; j <= i; j++) {
					if (n % j == 0 && i % j == 0) {
						divisorFound = true;
						break;
					}
				}

				if (!divisorFound) {
					fin++;
//					System.out.println("n: " + n + " i: " + i
//							+ " relative primes");
				}
			}

			double ratio = ((double) n / (double) fin);
			if(ratio > max) {
				max = ratio;
				System.out.println("max: " + max);
			}
			
			System.out.println("n: " + n + " fin: " + fin + " n/fin: "
					+ ratio);
		}
		System.out.println("max: " + max);
	}

	public static void main(String[] args) {
		new TotientMaximum();
	}

}
