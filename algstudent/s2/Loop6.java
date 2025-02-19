package alg12;

public class Loop6 {

	public static long loop6(long n) {
		// O(n3log n)
		long cont = 0;
		long n1 = 1;
		
		for (long j=0;j <n; j*=2) //log n
				for (long i = 1; i <= n * n; i += 1)//n2
					for (long k=0; k <n; j++) //n
						cont++;
			
		
		return cont;
	}

	public static void main(String arg[]) {
		long t1, t2;
		int nTimes = Integer.parseInt(arg[0]);

		System.out.println("n\ttime\trepetions\tcounter");

		for (long n = 100; n <= 819200; n *= 2) {
			long c = 0;
			t1 = System.currentTimeMillis();

			for (int repetitions = 1; repetitions <= nTimes; repetitions++)
				c = loop6(n);

			t2 = System.currentTimeMillis();

			System.out.println(n + "\t" + (t2 - t1) + "\t" + nTimes + "\t\t" + c);
		} // for
	} // main
	
} 