package alg6;



public class NullPathTimes {

	
	public static void main(String[] args) {
		long t1, t2, tSum = 0;
		for (int n =40; n<Integer.MAX_VALUE; n = n+5 ) {
			
			

			for (int i =0; i<100;i++) {
				t1 = System.currentTimeMillis();
				new NullPath(n).calculateNullPathWithoutPrints(); 

				t2 = System.currentTimeMillis();
				tSum += t2 - t1; 
			}
				
				
			
			System.out.println("n=" + n + "**TIME=" + (tSum/100));
		}

	}
}
