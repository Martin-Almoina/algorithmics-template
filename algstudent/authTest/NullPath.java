package alg6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class NullPath {

	private static final double p1 = 0.5;
	private static final double p2 = 0.5;
	private static final int minWeight = 10;
	private static final int maxWeight = 99;
	
	private static final int solutionTolerance= 75;
	
	
	
	private int[][] weights;
	private int n;
	
	List<Integer> path ;
	boolean[] visited; 
	private int sum;
	int toleranceLimit;
	
	int originNode ;
	int targetNode;
	
	boolean nextWeightEven;
	Map<Integer,Integer> nodesToWeights;
	
	private boolean found = false;
	
	

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		
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
		
		nextWeightEven = true;
		this.nodesToWeights =new HashMap<Integer,Integer>();
		
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
		if(found()) {
		//	System.out.println("Solution found ");
		//	printPath();
			found = true;
		}else {		
			if (sum<toleranceLimit &&sum> -toleranceLimit && path.size()<=n /*&& firstAndLast()*/ ) {
	
				for(int i= 0;i<n;i++) {
					if (!path.contains((Integer)i)) { // nodes cannot be visited twice  
					sum+= weights[origin][i];
					path.add(i);
					visited[i]=true;
				//	System.out.println(origin);
			//		System.out.print(i);
					
					backtrackingWithoutPrints(i);
					
					visited[i]=false;
					path.remove((Integer)i);
					sum-= weights[origin][i];
					}
				}
			}
		}
		
		
	}



	private void backtracking(int origin) {
		if(found()  && !found) {
			System.out.println("Solution found ");
			printPath();
			found = true;
		}else {		
			if (sum<toleranceLimit &&sum> -toleranceLimit && path.size()<=n /*&& firstAndLast()*/ ) {
	
				for(int i= 0;i<n;i++) {
					if (!path.contains((Integer)i)) { // nodes cannot be visited twice  
					if (this.nextWeightEven) { //next weight must be even
						if (isEven(weights[origin][i])) {
							
							sum+= weights[origin][i];
							path.add(i);
							this.nodesToWeights.put(i, weights[origin][i]);
							visited[i]=true;
							
							nextWeightEven = !nextWeightEven;
							
							backtracking(i);
							
							nextWeightEven = !nextWeightEven;
							
							visited[i]=false;
							path.remove((Integer)i);
							this.nodesToWeights.remove(i);
							sum-= weights[origin][i];
						
						}
					} else { // next weight must be odd
						if (!isEven(weights[origin][i])) {
							
							sum+= weights[origin][i];
							path.add(i);
							this.nodesToWeights.put(i, weights[origin][i]);
							visited[i]=true;
							
							nextWeightEven = !nextWeightEven;
							
							backtracking(i);
							
							nextWeightEven = !nextWeightEven;
							
							visited[i]=false;
							path.remove((Integer)i);
							
							this.nodesToWeights.remove(i);
							sum-= weights[origin][i];
						}
					}
	
					}
				}
			}
		}		
	}

	private boolean isEven(int i) {
		return i%2==0;
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
			System.out.print(" --->");
			System.out.print(" Weigth : ");
			System.out.print(nodesToWeights.get(i));
			
			System.out.print(" Node ");
			System.out.print(i);
			
			
		}
		
		System.out.print("\n");
		System.out.print("Sum :"+sum);
		System.out.print("\n");
		System.out.print("\n");
		
		for (int i=0; i<weights.length; i++) {
			for (int j=0; j<weights.length; j++) {
				System.out.print(weights[i][j]);
				System.out.print(" | ");
			}
			System.out.println("");
		}
			
	}

	private boolean found() {
		return sum<=solutionTolerance && sum>=-solutionTolerance  &&  pathContainsAll() && firstAndLast() ;
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
