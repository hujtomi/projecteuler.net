package powerfuldigitcounts;

import java.math.BigInteger;

public class PowerfulDigitCounts {

	public PowerfulDigitCounts() {

		int counter = 0;
		for (int i = 1; i < 1000; i++) {
			
			BigInteger base = new BigInteger("1");
			
			do {
				
				BigInteger val = base.pow(i);
				
				
				if(val.toString().length() == i){
					System.out.println(base + " ^ " + i + " = " + val);
					counter++;
				} 
				
				if(val.toString().length() > i){
					break;
				} 
				
				base = base.add(new BigInteger("1"));
			} while (true);
		}
		
		System.out.println("solution: " + counter);
	}

	public static void main(String[] args) {
		new PowerfulDigitCounts();
	}

}
