package alg4.lab7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphColouring {
	
	private static String[] colors = {"red", "blue", "green", "yellow", "orange", "purple", "cyan", "magenta", "lime"};
	
	
	// map | key: color | value: list with every node that has been assigned that color
	private static Map<String, List<String>> nodesWithColor;

	public static Map<String, String> greedy(Map<String, List<String>> graph) {
		 Map<String, String> result =new HashMap<String,String>();// <key,color>
		 
		 
		 
		
		 nodesWithColor = new HashMap<String,List<String>>();
		 for (int i=0; i<colors.length;i++) {
			 nodesWithColor.put(colors[i], new ArrayList<String>());
		 }
		 
		
		 for ( String key  : graph.keySet()) { // iterate over every node

			String colorTobeAssigned = null;
			List<String> neighbours = graph.get(key); 
			
			
			
			// find available color
			 for (int i=0; i<colors.length;i++) {
				 if (!neighboursColor(neighbours,colors[i])) {
					 colorTobeAssigned = colors[i];
					 nodesWithColor.get(colors[i]).add(key); //add node to list of nodes that have this color
					 break;
				 }
			 } 
			 
			 result.put(key, colorTobeAssigned);
			 
		 }
		 
		return result;
	}

	
	
	private static boolean neighboursColor(List<String> neighbours, String color) {
		List<String> nodesWithThisColor = nodesWithColor.get(color);
		String  n;
		for (int i =0 ; i<neighbours.size(); i++) {
			
			n =String.valueOf(neighbours.get(i));
						
			if(nodesWithThisColor.contains(n)) {
				return true;
			}
		}
		
		return false;
	}

}
