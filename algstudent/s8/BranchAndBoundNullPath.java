package alg7;

import java.util.ArrayList;

import alg7.utils.*;

/**
 * Main class to solve problems using the Branch and Bound technique
 * We need to extend it for any specific problem
 * @author viceg
 */
public class BranchAndBoundNullPath {
	protected Heap ds; //Nodes to be explored (not used nodes)
	protected Node bestNode; //To save the final node of the best solution
	protected Node rootNode; //Initial node
	protected int pruneLimit; //To prune nodes above this value
	       
	/**
	 * Constructor for BrancAndBount objects
	 */
	public BranchAndBoundNullPath() {
		ds = new Heap(); //We create an instance of the Heap class to save the nodes
	}
	      
	/**
	 * Manages all the process, from the beginning to the end
	 * @param rootNode Starting state of the problem
	 */
	public void branchAndBound(Node rootNode) { 
		ds.insert(rootNode); //First node to be explored
		
		boolean foundFirstPath=false;
	
		pruneLimit = rootNode.initialValuePruneLimit();

		while (!ds.empty() && ds.estimateBest() < pruneLimit) {
			Node node = ds.extractBestNode();	
			
			ArrayList<Node> children = node.expand(); 
			
			for (Node child : children)
				if (child.isSolution()) {
					
					foundFirstPath=true;
					
					int cost = child.getHeuristicValue();
					if (cost < pruneLimit) {
						pruneLimit = cost;
						bestNode = child;
					}
					
					//break;
				}
				else
					if (child.getHeuristicValue() < pruneLimit &&!child.prune()) {
						ds.insert(child);
					}
			
			if(foundFirstPath) {
				break;
			}
			
		} //while
	}
		
	/**
	 * Gets the root node
	 * @return The root node
	 */
    public Node getRootNode() {
    	return rootNode;
    }
    
	/**
	 * Gets the best node
	 * @return The best node
	 */
    public Node getBestNode() {
    	return bestNode;
    }

  
}
