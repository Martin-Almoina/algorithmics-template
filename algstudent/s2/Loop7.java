package alg12;

public class Loop7 {

	public static long loop7(int n) {
		long cont = 0;
		for (int i = 1; i <= n; i=+3)
			for (int j = 1; j <= n; j=+3)
				for (int k = 1; k <= n; k=+3)
					for (int h = 1; h <= n; h=+3)
					cont++;
		return cont;

	}

	public static void main(String arg[]) {
		long c = 0;
		long t1, t2;

		int nTimes = Integer.parseInt(arg[0]);

		System.out.println("n\ttime\trepetions\tcounter");

		for (int n = 100; n <= 819200; n *= 2) {
			t1 = System.currentTimeMillis();

			for (int repetitions = 1; repetitions <= nTimes; repetitions++)
				c = loop7(n);

			t2 = System.currentTimeMillis();

			System.out.println(n + "\t" + (t2 - t1) + "\t" + nTimes + "\t\t" + c);
		} // for
	} // main

} 