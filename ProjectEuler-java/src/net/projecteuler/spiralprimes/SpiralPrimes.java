package net.projecteuler.spiralprimes;

public class SpiralPrimes {

	int[][] spiral;

	public SpiralPrimes() {
		for (int spiralSize = 7; spiralSize < 3000; spiralSize += 2) {
			spiral = new int[spiralSize][spiralSize];

			int counter = 1;
			for (int i = spiralSize; i > 0; i -= 2) {
				int cellValue = i * i;
				int posX = spiralSize - counter;
				int posY = spiralSize - counter;
				counter++;

				for (int j = 0; j < i; j++) {
					spiral[posX][posY--] = cellValue--;
				}

				cellValue++;
				posY++;

				for (int j = 0; j < i; j++) {
					spiral[posX--][posY] = cellValue--;
				}

				cellValue++;
				posX++;

				for (int j = 0; j < i; j++) {
					spiral[posX][posY++] = cellValue--;
				}

				cellValue++;
				posY--;

				for (int j = 0; j < i - 1; j++) {
					spiral[posX++][posY] = cellValue--;
				}
			}

			int primeCounter = 0;
			for (int i = 2; i <= spiralSize * spiralSize; i++) {
				if (isPrime(i))
					primeCounter++;
			}

			int diagonalCounter = 0;

			for (int i = 0; i < spiralSize; i++) {
				if (isPrime(spiral[i][i])) {
					//System.out.println(spiral[i][i]);
					diagonalCounter++;
				}

				if (isPrime(spiral[i][spiralSize - 1 - i])) {
					//System.out.println(spiral[i][spiralSize - 1 - i]);
					diagonalCounter++;
				}
			}
			
			System.out.println("for " + spiralSize + " x " + spiralSize + " : " + diagonalCounter + " / "
					+ primeCounter 
					+ " ratio: "
					+ ((double) diagonalCounter * 100d / (double) primeCounter) + "%");

		}
	}

	private static boolean isPrime(int num) {
		if(num == 1)
			return false;
		
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
		new SpiralPrimes();

	}

}
