package alg6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NullPath {

	private static final double p1 = 0.5;
	private static final double p2 = 0.5;
	private static final int minWeight = 10;
	private static final int maxWeight = 99;
	
	private int[][] weights;
	private int n;
	
	List<Integer> path ;
	boolean[] visited; 
	private int sum;
	int toleranceLimit;
	
	
	private boolean found = false;
	
	

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		
		
		new NullPath(n).calculateNullPath();; 
		

	}
	
	public NullPath(int n) {
		this.n=n;
		generateGraph(n);
	}
	
	public void calculateNullPath() {
		int origin = 0;
		int target = weights.length-1;
		
		path = new ArrayList<Integer>();
		sum=0;
		visited = new boolean[n];
		toleranceLimit=n*maxWeight;
		
		backtracking(origin);
		if(!found)
			System.out.println("No solution");

	}



	private void backtracking(int origin) {
		if(found()) {
			System.out.println("Solution found \n");
			printPath();
			found = true;
		}else {
			
			if (sum<toleranceLimit &&sum> -toleranceLimit && path.size()<n) {
				for(int i= origin;i<n;i++) {
					sum+= weights[origin][i];
					path.add(i);
					visited[i]=true;
					
					backtracking(i);
					
					visited[i]=false;
					path.remove((Integer)i);
					sum-= weights[origin][i];
				}
			}
		}		
	}

	private void printPath() {
		for(int i : path) {
			System.out.print("--->");
			System.out.print(i);
			
		}
		
	}

	private boolean found() {
		return sum<=maxWeight && sum>=-maxWeight && allNodesVisited() && pathContainsAll() ;
	}
	


	private boolean pathContainsAll() {
		for(int i=0; i<n; i++) {
			if(!path.contains(i))
				return false;
		}
		
		return true;
	}

	private boolean allNodesVisited() {
		for (int i =0 ;i<visited.length; i++ ) {
			if(!visited[i])
				return false;
		}
		return true;
	}

	private void generateGraph(int n) {
		weights = new int[n][n];
		
		Random rand = new Random();
		
		for (int origin=0;origin<n; origin++) {
			for(int dest=0;dest<n;dest++) {
				if (rand.nextInt()<p1) {
					weights[origin][dest] = rand.nextInt(minWeight, maxWeight);
				}else {
					weights[origin][dest] = rand.nextInt(-maxWeight, -minWeight);
				}
			}
		}
		
	}

}
