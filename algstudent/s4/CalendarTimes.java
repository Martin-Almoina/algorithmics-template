package alg3;

public class CalendarTimes {

	
	 public static void main(String[] args) {
		String[] names ;
	    int nTimes=100;
			    
		long t1,t2;
		for (int n=2; n<100000; n*=2) { 
			
			names = new String[n];
			for (int i=0; i<n ; i++) {
				names[0] = Integer.toString(i);
			}
			
			t1= System.currentTimeMillis();

			for (int repeticiones=1; repeticiones<=nTimes; repeticiones++) 
				Calendar.generateSchedule(names); 		
			t2= System.currentTimeMillis();
			
			System.out.println ("ORDER = "+n+"**"+"TIME = "+(t2-t1)+"**"); 
	}   
			
	    }
}
