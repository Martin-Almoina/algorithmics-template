package alg5;

public class MinimumPathsTimes {

	public static void main(String[] args) {
		long t1, t2;
		for (int n =200; n<Integer.MAX_VALUE; n = n*2 ) {
			
			t1 = System.currentTimeMillis();

			MinimumPaths.calculateMinimumPaths(n);

			t2 = System.currentTimeMillis();
			
		}

	}

}
