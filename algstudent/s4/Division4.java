package alg3;

/* Params: a=1;b=3;k=2
 * The time complexity is O(n^2) 

 */
public class Division4 {
	public static long rec4 (int n)
	{ 
	 long cont = 0;
	 if (n<=0) cont++;
	 else
	  {
		for (int i=1;i<n;i++)
			for (int j=1;j<n;j++) 
				cont++ ;  //O(n^2) = k=2
	  
	    rec4(n/3);
	  }
	 return cont;   
	}
	
	public static void main (String arg []) 
	{
		
		long t1,t2,cont = 0;
		for (int n=1000;n<=10000000;n*=2)
		 {
			 t1 = System.currentTimeMillis ();
			for (int reps=1; reps<2;reps++)
				cont=rec4(n);
			 
			 t2 = System.currentTimeMillis ();
			
			 System.out.println ("n="+n+ "**TIME="+(t2-t1)+"**cont="+cont);
		 }  // for
	} // main
} //class