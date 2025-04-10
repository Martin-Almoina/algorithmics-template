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
	
	int originNode ;
	int targetNode;
	
	
	private boolean found = false;
	
	

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		
		
		for (int i =0; i<100;i++)
			new NullPath(n).calculateNullPath(); 


	}
	
	public NullPath(int n) {
		this.n=n;
		generateGraph(n);
	}
	
	public void calculateNullPath() {
		 originNode = 0;
		 targetNode = weights.length-1;
		
		path = new ArrayList<Integer>();
		sum=0;
		visited = new boolean[n];
		toleranceLimit=n*maxWeight;
		
		backtracking(originNode);
		if(!found)
			System.out.println("No solution");

	}
	
	public void calculateNullPathWithoutPrints() {
		 originNode = 0;
		 targetNode = weights.length-1;
		
		path = new ArrayList<Integer>();
		sum=0;
		visited = new boolean[n];
		toleranceLimit=n*maxWeight;
		
		
		
		backtrackingWithoutPrints(originNode);
//		if(!found)
			//System.out.println("No solution");

	}
	
	private void backtrackingWithoutPrints(int origin) {
		 if(found) {
		    	return;
		    }
			if (isFound() || found) { 
		      //  System.out.println("Solution found");
		      //  printPath();
		        found = true;
		        return; 
		    }

		    if (sum < toleranceLimit && sum > -toleranceLimit && path.size() <= n) {
		        for (int i = 0; i < n; i++) {
		            if (!visited[i]) { 
		                sum += weights[origin][i];
		                path.add(i);
		                visited[i] = true;

		                backtrackingWithoutPrints(i);

		                
		                visited[i] = false;
		                path.remove(path.size() - 1); 
		                sum -= weights[origin][i];
		            }
		        }
		    }
		
		
	}



	private void backtracking(int origin) {
	    if(found) {
	    	return;
	    }
		if (isFound() || found) { 
	        System.out.println("Solution found");
	        printPath();
	        found = true;
	        return; 
	    }

	    

	    if (sum < toleranceLimit && sum > -toleranceLimit && path.size() <= n) {
	        for (int i = 0; i < n; i++) {
	            if (!visited[i]) { 
	                sum += weights[origin][i];
	                path.add(i);
	                visited[i] = true;

	                backtracking(i);

	                
	                visited[i] = false;
	                path.remove(path.size() - 1); 
	                sum -= weights[origin][i];
	            }
	        }
	    }
	}

	private boolean firstAndLast() {
		if (path.isEmpty())
			return false;
		
		return path.getFirst().equals(originNode) && path.getLast().equals(targetNode);
	}
	
	private boolean first() {
		if (path.isEmpty())
			return false;
		
		return path.getFirst().equals(originNode);
	}



	private void printPath() {
		for(int i : path) {
			System.out.print("--->");
			System.out.print(i);
			
		}
		System.out.print("\n");
	}

	private boolean isFound() {
		return sum<=maxWeight && sum>=-maxWeight  &&  pathContainsAll() && firstAndLast() ;
	}
	


	private boolean pathContainsAll() {
		for(int i=0; i<n; i++) {
			if(!path.contains(i))
				return false;
		}
		
		return true;
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
