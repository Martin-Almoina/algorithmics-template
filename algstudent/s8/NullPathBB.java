package alg7;

import java.util.Random;
import java.util.UUID;

import alg6.NullPath;
import alg7.utils.*;


public class NullPathBB {
	
	private static final double p1 = 0.5;
	private static final double p2 = 0.5;
	private static final int minWeight = 10;
	public static final int maxWeight = 99;
	
	private int[][] weights;
	private int n;
	
	int originNode ;
	int targetNode;
	
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		
		new NullPathBB(n).calculateNullPath(); 


	}
	
	public NullPathBB(int n) {
		this.n=n;
		generateGraph(n);
	}
	
	public void calculateNullPath() {
		
		NullPathNode rootNode = new NullPathNode();//depth = 0; parentID = null; ID = UUID.randomUUID();
		
		rootNode.cost=0;
		rootNode.path="0";
		rootNode.targetNode=0;
		rootNode.weights=this.weights;
		rootNode.visited=new boolean[n];
		rootNode.visited[rootNode.targetNode]=true;
		
		BranchAndBoundNullPath BB = new BranchAndBoundNullPath();
		
		BB.branchAndBound(rootNode);
		
	//	System.out.println(((NullPathNode) BB.bestNode).getPath());
		
	}
	
	private void generateGraph(int n) {
		weights = new int[n][n];
		
		Random rand = new Random();
		
		for (int origin=0;origin<n; origin++) {
			for(int dest=0;dest<n;dest++) {
				if (origin!=dest) {
					if (rand.nextDouble()<p1) {
						weights[origin][dest] = rand.nextInt(minWeight, maxWeight);
					}else {
						weights[origin][dest] = rand.nextInt(-maxWeight, -minWeight);
					}//else
				}//if
			}//for
		}//for
		
		
	}

}
