package net.projecteuler.triangularpentagonalhexagonal;

public class TriangularPentagonalHexagonal {

	public TriangularPentagonalHexagonal() {
		long[] triangle = new 	long[100000];
		long[] penta = new 		long[100000];
		long[] hexa = new 		long[100000];

		for (long i = 1; i <= triangle.length; i++) {
			triangle[(int)i-1] = (long) (i * (i + 1) / 2);
			penta[(int)i-1] = (long) (i * ((3 * i) - 1) / 2);
			hexa[(int)i-1] = i * ((2*i) - 1);

		}
		
		for (int i = 0; i < triangle.length; i++) {
			
			for (int j = 0; j < penta.length; j++) {
				if(penta[j] == triangle[i]){
					for (int k = 0; k < hexa.length; k++) {
						if(hexa[k] == triangle[i]){
							System.out.println("match: " + triangle[i]);
							System.out.println("i: " + i + " j: " + j + " k: " + k);
							break;
						}
						
						if(hexa[k] > triangle[i])
							break;
					}
				}
				
				if(penta[j] > triangle[i])
					break;
			}
		}
		
		System.out.println("end");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new TriangularPentagonalHexagonal();

	}

}
