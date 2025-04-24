package alg7;

public class NullPathTimesBB {

	public static void main(String[] args) {
		long t1, t2;
		int reps = 100;
		for (int n = 20; n<Integer.MAX_VALUE;n+=5) {
			
			t1 = System.currentTimeMillis();
			for (int i =0; i<reps;i++)
				new NullPathBB(n).calculateNullPath();;
			
			t2 = System.currentTimeMillis();

			System.out.println("n=" + n + "**TIME=" + (t2 - t1)/reps);
		}

	}

}
