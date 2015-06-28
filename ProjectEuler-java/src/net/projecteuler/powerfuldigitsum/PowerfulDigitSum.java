package net.projecteuler.powerfuldigitsum;

import java.math.BigInteger;

public class PowerfulDigitSum {

	public PowerfulDigitSum() {
		
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				BigInteger val = new BigInteger(Integer.toString(i));
				BigInteger res = val.pow(j);
				
				char[] resChars = res.toString().toCharArray();
				
				int sum = 0;
				for (char c : resChars) {
					sum += Integer.parseInt(Character.toString(c));
				}
				
				if(sum > max)
					max = sum;
			}
		}
		
		System.out.println(max);
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new PowerfulDigitSum();

	}

}
