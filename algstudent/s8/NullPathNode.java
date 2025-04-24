package alg7;

import java.util.ArrayList;
import java.util.UUID;

import alg7.utils.Node;

public class NullPathNode extends Node {
	boolean[] visited;
	int[][] weights;
	
	int cost;
	int targetNode;
	String path;
	
	NullPathNode parent;
	
	
	

	public NullPathNode(int target, NullPathNode parent) {
		this.targetNode= target;
		this.depth=parent.depth+1;
		this.parent=parent;
		this.parentID=parent.ID;
		this.weights=parent.weights;
		
		this.ID=UUID.randomUUID();
		
		this.visited=parent.visited.clone();
		this.visited[target]=true;
		
		this.cost = parent.cost+weights[parent.targetNode][target];
		this.path = parent.path.concat("--->"+target);
	}

	public NullPathNode() {
		super();
	}

	@Override
	public void calculateHeuristicValue() {
		// heuristic : the distance the cost is from 0 (negative or positive)
		this.heuristicValue=Math.abs(cost);

	}

	@Override
	public ArrayList<Node> expand() {
		ArrayList<Node> result = new  ArrayList<Node>();
		for (int i = 0 ; i<visited.length;i++) {
			if(!visited[i]) {
				result.add(new NullPathNode(i,this));
			}
		}
		 
		return result;
	}

	@Override
	public boolean isSolution() {
		
		return this.getHeuristicValue()<NullPathBB.maxWeight && visited[visited.length-1] && visitedAllNodes() && this.targetNode==visited.length-1;
	}

	private boolean visitedAllNodes() {
		for (int i=0; i<visited.length;i++)
			if(!visited[i])
				return false;
		
		return true;
	}

//	@Override
	protected String getPath() {
		
		return path;
	}

	@Override
	public boolean prune() {
		// if we haven't visited every node but have already visited the last we prune
		return !visitedAllNodes() && visited[visited.length-1];
	}

}
