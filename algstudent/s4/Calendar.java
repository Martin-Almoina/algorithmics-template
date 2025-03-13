package alg3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calendar {


	  public static void main(String[] args) {
	        //String fileName = args[0];
	        
			//nameArray= (String[]) readNamesFromFile(fileName).toArray();
			String[] nameArray = {"Vanesa", "Victor", "Tomas", "Alba"};
			
			String[][] playerMatches = generateSchedule(nameArray);

		     printSchedule(nameArray, playerMatches);
			
	    }

	    public static List<String> readNamesFromFile(String filePath) {
	        List<String> names = new ArrayList<>();
	        
	        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
	            int nNames = Integer.parseInt(reader.readLine());
	            
	            for (int i = 0; i < nNames; i++) {
	                names.add(reader.readLine()); 
	            }
	            
	        } catch (IOException | NumberFormatException e) {
	            System.err.println("Error reading file");
	          }
	        
	        return names;
	        
	    }
	    
	    
	        public static String[][] generateSchedule(String[] contestants) {
	            int n = contestants.length;
	            String[][] playerMatches = new String[n][n - 1]; // n players play (n-1) matches

	            String[] players = Arrays.copyOf(contestants, n);

	            for (int day = 0; day < n - 1; day++) { //O(n)
	                for (int i = 0; i < n / 2; i++) { // O(n)
	                    String player1 = players[i];
	                    String player2 = players[n - 1 - i];

	                    int p1Index = Arrays.asList(contestants).indexOf(player1); // O(n)
	                    int p2Index = Arrays.asList(contestants).indexOf(player2);

	                    playerMatches[p1Index][day] = player2;
	                    playerMatches[p2Index][day] = player1;
	                }

	                //
	                String temp = players[n - 1];
	                for (int i = n - 1; i > 1; i--) {
	                    players[i] = players[i - 1];
	                }
	                players[1] = temp;
	            }

	            return playerMatches;
	        }

	        private static void divideAndConquerSchedule(String[] players, String[][] playerMatches, int start, int size) {
	            if (size == 2) {
	                playerMatches[start][0] = players[start + 1];
	                playerMatches[start + 1][0] = players[start];
	                return;
	            }

	            int half = size / 2;
	            divideAndConquerSchedule(players, playerMatches, start, half);
	            divideAndConquerSchedule(players, playerMatches, start + half, half);

	            // Merge phase: Assign cross-matches between two halves
	            for (int day = 0; day < size - 1; day++) {
	                for (int i = 0; i < half; i++) {
	                    int player1Index = (start + i) % size;
	                    int player2Index = (start + half + i) % size;

	                    playerMatches[player1Index][day] = players[player2Index];
	                    playerMatches[player2Index][day] = players[player1Index];
	                }
	            }
	        }

	        public static void printSchedule(String[] contestants, String[][] schedule) {
	            int n = contestants.length;
	            int width = 20;

	            
	            System.out.printf("%-" + width + "s", "PLAYER/OPPONENT");
	            for (int day = 1; day < n; day++) {
	                System.out.printf("%-" + width + "s", "DAY " + day);
	            }
	            System.out.println();

	    
	            for (int i = 0; i < n; i++) {
	                System.out.printf("%-" + width + "s", contestants[i]);
	                for (int day = 0; day < n - 1; day++) {
	                    System.out.printf("%-" + width + "s", schedule[i][day]);
	                }
	                System.out.println();
	            }
	        
	    
}
}
