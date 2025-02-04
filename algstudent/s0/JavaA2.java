package alg;

import java.util.ArrayList;
import java.util.List;

public class JavaA2 {
	public static void main(String args[]) {
		 int n = 10000;
		 for (int i=0; i<7;i++) {
			 
			 long startTime = System.currentTimeMillis();
			 List<Integer> primes = listPrimes(n);
			 long stopTime = System.currentTimeMillis();
			 
			 System.out.println("N = "+ n );
			 System.out.println("time = "+(stopTime - startTime));
			 n=n*2;
		 }
	}

	private static List<Integer> listPrimes(int n) {
		List<Integer> result = new ArrayList<Integer>();
		for(int i=2;i<=n;i++) {
			if(isPrime(i))
				result.add(i);
		}
		return result;
	}

	private static boolean isPrime(int i) {
		for (int j=2;j<i; j++) {
			if (i%j==0) {
				return false;
			}
		}
		return true;
	}
}
