package alg4.lab7;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Greedy {
	public static void main(String[] args) {
		JSONParser parser = new JSONParser();
		try (FileReader reader = new FileReader("C:\\Users\\HP\\Desktop\\Martin\\alg_ws\\Alg1\\src\\alg4\\lab7\\Session 4\\Session 4\\sols\\g64.json")) {
			JSONObject jsonObject = (JSONObject) parser.parse(reader);
			@SuppressWarnings("unchecked")
			Map<String, List<String>> graph = (Map<String, List<String>>) jsonObject.get("graph");

			Map<String, String> solution = GraphColouring.greedy(graph);
			try (FileWriter file = new FileWriter("solution.json")) {
				file.write(new JSONObject(solution).toJSONString());
			}

			if (solution != null) {
				System.out.println("Solution found: " + solution);
			} else {
				System.out.println("Solution not found.");
			}
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		} 	
		}
	
	public static void graphColouring(String filename) {
		JSONParser parser = new JSONParser();
		try (FileReader reader = new FileReader(filename)) {
			JSONObject jsonObject = (JSONObject) parser.parse(reader);
			@SuppressWarnings("unchecked")
			Map<String, List<String>> graph = (Map<String, List<String>>) jsonObject.get("graph");

			Map<String, String> solution = GraphColouring.greedy(graph);
			try (FileWriter file = new FileWriter("solution.json")) {
				file.write(new JSONObject(solution).toJSONString());
			}

			if (solution != null) {
				//System.out.println("Solution found: " + solution);
			} else {
				System.out.println("Solution not found.");
			}
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		} 
	}
	
	
	
	
	
	
}
