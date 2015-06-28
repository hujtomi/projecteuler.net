package net.projecteuler.pentagonnumbers;

public class PentagonNumbers {

	//not working
	public PentagonNumbers() {

		int[] pentagonNumbers = new int[5000];
		
		for (int i = 1; i <= pentagonNumbers.length; i++) {
			pentagonNumbers[i-1] = i * ((3 * i) - 1) / 2;			
		}
		
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < pentagonNumbers.length; i++) {
			for (int j = i; j < pentagonNumbers.length; j++) {
				
				int k = pentagonNumbers[i] + pentagonNumbers[j];
				int l = Math.abs(pentagonNumbers[i] - pentagonNumbers[j]);
				
				if(isPentagonal(pentagonNumbers, k) 
						&& isPentagonal(pentagonNumbers, l)
						){
					System.out.println("hit: " + pentagonNumbers[i] + " l: " + pentagonNumbers[j]);
					if(l < min)
						min = l;
				}
			}
		}
		
		System.out.println("min diff: " + min);
		
		
	}
	
	public boolean isPentagonal(int[] array, int num)
	{
		for (int i = 0; i < array.length; i++) {
			if(array[i] == num)
			{				
				return true;				
			}
			
			if(array[i] > num)
				return false;
		}
		
		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new PentagonNumbers();

	}

}
