package alg6;



public class NullPathTimes {

	
	public static void main(String[] args) {
		long t1, t2;
		for (int n =2; n<Integer.MAX_VALUE; n = n+1 ) {
			
			t1 = System.currentTimeMillis();

			for (int i =0; i<1;i++)
				new NullPath(n).calculateNullPathWithoutPrints(); 

			t2 = System.currentTimeMillis();
				
			
			System.out.println("n=" + n + "**TIME=" + (t2 - t1));
		}

	}
}
