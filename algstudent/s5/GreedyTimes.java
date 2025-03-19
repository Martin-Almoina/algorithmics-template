package alg4.lab7;

public class GreedyTimes {
	
	
	public static void main(String[] args) {
		int reps = Integer.parseInt(args[0]);
		long t1,t2;
		
		for (int i=8; i<9000; i*=2) {
			
			String filename = "C:\\Users\\HP\\Desktop\\Martin\\alg_ws\\Alg1\\src\\alg4\\lab7\\Session 4\\Session 4\\sols\\g"+i+".json";
			t1= System.currentTimeMillis();
			
			for (int r =0 ; r <reps; r++)
				Greedy.graphColouring(filename);
			t2= System.currentTimeMillis();
			
			System.out.println ("Graph of size = "+i+"  "+"TIME = "+(t2-t1));
		}
	}

}
