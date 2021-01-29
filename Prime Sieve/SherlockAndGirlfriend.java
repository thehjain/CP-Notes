import java.util.*;
import java.io.*;
import java.math.*;

class SherlockAndGirlfriend {

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;
	private static int MOD = 1000000007;
	static FastScanner sc = new FastScanner();
	static int n = 100003;
	static int[] res = new int[n + 2];

	public static void main(String[] args) throws IOException {
		// int T = sc.nextInt();
		// while (T-- > 0) {
		sieve();
		solve();
		// }
	}

	static void solve() throws IOException {

		int n = sc.nextInt();

		if (n == 1) {
			System.out.println(1);
			System.out.println(1);
			return;
		}
		if (n == 2) {
			System.out.println(1);
			System.out.println(1 + " " + 1);
			return;
		}

		System.out.println(2);

		for (int i = 2; i <= n + 1; i++)
			System.out.print(res[i] + " ");

	}

	static void sieve() {

		boolean[] isPrime = new boolean[n + 2];
		Arrays.fill(isPrime, true);
		Arrays.fill(res, 1);
		int index = 1;

		for (int p = 2; p * p <= n; p++) {
			if (isPrime[p]) {
				res[p] = 1;
				// System.out.print(p + " ");
				for (int i = p * p; i <= n; i += p) {
					isPrime[i] = false;
					res[i] = 2;
				}
			}
		}
	}

	static class FastScanner {
		public BufferedReader reader;
		public StringTokenizer tokenizer;
		public FastScanner() {
			reader = new BufferedReader(new InputStreamReader(System.in), 32768);
			tokenizer = null;
		}
		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}
		public int nextInt() {
			return Integer.parseInt(next());
		}
		public long nextLong() {
			return Long.parseLong(next());
		}
		public double nextDouble() {
			return Double.parseDouble(next());
		}
		public String nextLine() {
			try {
				return reader.readLine();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

}