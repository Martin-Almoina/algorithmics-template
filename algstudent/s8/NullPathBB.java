package alg7;

import java.util.Random;

import alg7.utils.*;


public class NullPathBB {
	
	private static final double p1 = 0.5;
	private static final double p2 = 0.5;
	private static final int minWeight = 10;
	private static final int maxWeight = 99;
	
	private int[][] weights;
	private int n;
	
	int originNode ;
	int targetNode;
	
	public NullPathBB(int n) {
		this.n=n;
		generateGraph(n);
	}
	
	public void calculateNullPath() {
		
		new BranchAndBoundNullPath().branchAndBound(null);;
		
	}
	
	
	
	
	
	private void generateGraph(int n) {
		weights = new int[n][n];
		
		Random rand = new Random();
		
		for (int origin=0;origin<n; origin++) {
			for(int dest=0;dest<n;dest++) {
				if (origin!=dest) {
					if (rand.nextInt()<p1) {
						weights[origin][dest] = rand.nextInt(minWeight, maxWeight);
					}else {
						weights[origin][dest] = rand.nextInt(-maxWeight, -minWeight);
					}//else
				}//if
			}//for
		}//for
		
		
	}

}
