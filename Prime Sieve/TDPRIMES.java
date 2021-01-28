import java.util.*;
import java.io.*;
import java.math.*;

class TDPRIMES {

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;
	private static int MOD = 1000000007;
	// static FastScanner sc = new FastScanner();
	static int count = 0;
	static ArrayList<Integer> prime = new ArrayList<>();
	static int n = 100000000;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// int T = sc.nextInt();
		sieve((int)Math.floor(Math.sqrt(n)) + 1);
		// while (T-- > 0) {
		solve();
		// }
		System.out.print(sb);
	}

	static void solve() throws IOException {

		int limit = (int)Math.floor(Math.sqrt(n)) + 1;

		int low = limit;
		int high = 2 * limit;

		while (low < n) {

			if (high >= n)
				high = n;

			boolean[] isPrime = new boolean[limit + 1];
			Arrays.fill(isPrime, true);

			for (int i = 0; i < prime.size(); i++) {

				int lo = (low / prime.get(i)) * prime.get(i);

				if (lo < low)
					lo += prime.get(i);

				for (int j = lo; j < high; j += prime.get(i))
					isPrime[j - low] = false;
			}

			for (int i = low; i < high; i++)
				if (isPrime[i - low]) {
					count++;
					if (count % 100 == 1)
						sb.append(i + "\n");
				}

			low = low + limit;
			high = high + limit;

		}

	}

	static void sieve(int n) {

		boolean[] isPrime = new boolean[n];

		Arrays.fill(isPrime, true);
		isPrime[1] = false;
		for (int p = 2; p * p < n; p++) {
			if (isPrime[p]) {
				for (int i = p * p; i < n; i += p)
					isPrime[i] = false;
			}
		}

		for (int i = 2; i < n; i++)
			if (isPrime[i]) {
				count++;
				if (count % 100 == 1)
					sb.append(i + "\n");
				prime.add(i);
			}

	}

	// static class FastScanner {
	// 	public BufferedReader reader;
	// 	public StringTokenizer tokenizer;
	// 	public FastScanner() {
	// 		reader = new BufferedReader(new InputStreamReader(System.in), 32768);
	// 		tokenizer = null;
	// 	}
	// 	public String next() {
	// 		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
	// 			try {
	// 				tokenizer = new StringTokenizer(reader.readLine());
	// 			} catch (IOException e) {
	// 				throw new RuntimeException(e);
	// 			}
	// 		}
	// 		return tokenizer.nextToken();
	// 	}
	// 	public int nextInt() {
	// 		return Integer.parseInt(next());
	// 	}
	// 	public long nextLong() {
	// 		return Long.parseLong(next());
	// 	}
	// 	public double nextDouble() {
	// 		return Double.parseDouble(next());
	// 	}
	// 	public String nextLine() {
	// 		try {
	// 			return reader.readLine();
	// 		} catch (IOException e) {
	// 			throw new RuntimeException(e);
	// 		}
	// 	}
	// }

}