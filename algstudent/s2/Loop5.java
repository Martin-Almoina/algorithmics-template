package alg12;

public class Loop5 {

	public static long loop5(long n) {
		// O(n2	log2n)
		long cont = 0;
		long n1 = 1;
		
		for (long j=0;j <n; j*=2) { //log n
			for (long k=0; k <n; j*=2) {//log n
				for (long i = 1; i <= n * n; i += 5){//n2
					cont++;
					}
			}
		}
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
				c = loop5(n);

			t2 = System.currentTimeMillis();

			System.out.println(n + "\t" + (t2 - t1) + "\t" + nTimes + "\t\t" + c);
		} // for
	} // main
	
} 