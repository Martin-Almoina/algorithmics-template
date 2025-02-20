package alg2;

/* This program is used to sort n elements with a quadratic algorithm
except if the vector is initially ordered or nearly ordered,
which is of linear complexity (INSERTION) */
public class Insertion2 {
	static int[] v;

	/* Sorting by the Insertion method */
	public static void insertion(int[] a,int left, int right) {
		int j;
		int pivot;
		int n = right;
		
		for (int i =  left+1; i < n; i++) {
			pivot = a[i];
			j = i-1;
			
			while (j >= left && pivot < a[j]) {
				a[j+1] = a[j];
				j--;
			}
			
			a[j+1] = pivot;
		}
	}

	public static void main(String arg[]) {
		int n = Integer.parseInt(arg[0]); //size of the problem
		v = new int[n];

		Vector.sorted(v);
		System.out.println("VECTOR TO BE SORTED");
		Vector.print(v);
		insertion(v,0,v.length);
		System.out.println("SORTED VECTOR");
		Vector.print(v);

		Vector.reverseSorted(v);
		System.out.println("VECTOR TO BE SORTED");
		Vector.print(v);
		insertion(v,0,v.length);
		System.out.println("SORTED VECTOR");
		Vector.print(v);

		Vector.randomSorted(v);
		System.out.println("VECTOR TO BE SORTED");
		Vector.print(v);
		insertion(v,0,v.length);
		System.out.println("SORTED VECTOR");
		Vector.print(v);
	} 

}
