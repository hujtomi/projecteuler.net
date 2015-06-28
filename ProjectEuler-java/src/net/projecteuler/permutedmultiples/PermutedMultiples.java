package net.projecteuler.permutedmultiples;

public class PermutedMultiples {

	public PermutedMultiples() {
		
		for (int i = 1; i < 10000000; i++) {
			
			if(containsTheSameDigits(i, 2*i)
					&& containsTheSameDigits(i, 3*i)
					&& containsTheSameDigits(i, 4*i)
					&& containsTheSameDigits(i, 5*i)
					&& containsTheSameDigits(i, 6*i))
				System.out.println(i);
		}		
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
		new PermutedMultiples();
	}

}
