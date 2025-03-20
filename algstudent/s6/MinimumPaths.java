package alg5;

import java.util.Random;

public class MinimumPaths {
	private final static double p1 = 0.5; // prob that an edge exists
	private final static double p2 = 0.5; 
	
	private static final int NO_CONNECTION_VALUE = 10000000;


	private final static int minWeight=10; 
	private final static int maxWeight=99;
	
	private static int[][] weights;
	private static int[][] costs;
	private static int[][] p;
	private static String[] v;
	
	public static void  calculateMinimumPaths(int n) {
		v = new String[n];
		for (int i = 0; i < n; i++)
			v[i] = "NODE" + i;

		weights = new int[n][n];
		costs = new int[n][n];
		p = new int[n][n];
		
		fillInWeights(weights); //weights for the example
		System.out.println("WEIGHT MATRIX IS:");
		printMatrix(weights);

		floyd(weights, costs, p);

		System.out.println("MINIMUM COST MATRIX IS:");
		printMatrix(costs);

		System.out.println("P MATRIX IS:");
		printMatrix(p);
		
		System.out.println();
		System.out.println("MINIMUM PATHS IN THE EXAMPLE GRAPH (for every pair of different nodes):");
		System.out.println();
		for (int source = 0; source <= n-1; source++)
			for (int target = 0; target <= n-1; target++)
				if (source != target) {
					System.out.print("FROM " + v[source] + " TO " + v[target] + " = ");
					minimumPath(v, weights, costs, p, source, target);
					if (costs[source][target] < 10000000)
						System.out.println("MINIMUM COST=" + costs[source][target]);
					System.out.println("**************");
				}

	}
	
	
	static void minimumPath(String[] v, int[][] weights, int[][] costs, int[][] steps, int source, int target) {
		if (costs[source][target] == NO_CONNECTION_VALUE ) {
			System.out.println("THERE IS NO PATH");
			return;	
		}
		
		System.out.print(v[source]);
		System.out.print("--->");
		if (source == steps[source][target]) { // last step					
			System.out.print(v[target]+"\n");
			return;
		}
		
		source= steps[source][target];
		
		minimumPath(v, weights, costs, steps, source, target);
		
		
	}
	
	
	static void floyd(int[][] weights, int[][] costs, int[][] p) {
		int n = weights.length;
		int new_cost, current_cost;
		// copy weights into costs
		for(int i=0; i<n ; i++) 
			for(int j=0; j<n ; j++) {
				costs[i][j] = weights[i][j];
				
				if (costs[i][j] != NO_CONNECTION_VALUE)
					p[i][j] = i;
			}
		
		for (int pivot =0 ; pivot<n ; pivot++) {
			for(int i=0; i<n ; i++) {
				for(int j=0; j<n ; j++) {	
					current_cost = costs[i][j];
					new_cost = costs[i][pivot]+costs[pivot][j];
					
					if (new_cost < current_cost) {
						costs[i][j] = new_cost;
						p[i][j] = pivot;
					}	
				}
			}					
		}	
	}
	
	
	/* load the example cost matrix */
	static void fillInWeights(int[][] w) {
		Random rand = new Random();
		
		for (int i = 0; i < w.length; i++)
			for (int j = 0; j < w.length; j++)
				if (rand.nextDouble()<p1) {
					w[i][j] = rand.nextInt(minWeight, maxWeight+1);
				}
				
		
	}
	
	/* print the cost matrix */
	static void printMatrix(int[][] a) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				System.out.print(String.format("%10s", a[i][j]));
			System.out.println();
		}
		System.out.println();
	}
	
	
	
}
