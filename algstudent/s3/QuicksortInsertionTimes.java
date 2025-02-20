package alg2;

/* This class measures times for the quicksort method
for the 3 assumptions: (already ordered, reverse ordered and random ordered) */
public class QuicksortInsertionTimes {
	static int[] v;

	public static void main(String arg[]) {
		long t1, t2;
		//String opcion = arg[0];

		int n = 16000000;
		
		int k = 500;

		v = new int[n];

		Vector.randomSorted(v);

		t1 = System.currentTimeMillis();

		QuicksortInsertion.quicksort(v,k);

		t2 = System.currentTimeMillis();

		System.out.println(n + "\t" + (t2 - t1) +" "+k);
		}
	}

