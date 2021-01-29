import java.util.*;
import java.io.*;
import java.math.*;

class SoldierAndNumberGame {

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;
	private static int MOD = 1000000007;
	static FastScanner sc = new FastScanner();
	static StringBuilder sb = new StringBuilder();
	static int n = 5000001;
	static int[] res = new int[n];

	public static void main(String[] args) throws IOException {
		int T = sc.nextInt();
		sieve();
		while (T-- > 0) {
			solve();
		}
		System.out.print(sb);
	}

	static void solve() throws IOException {

		int a = sc.nextInt();
		int b = sc.nextInt();
		sb.append(res[a] - res[b] + "\n");
	}

	static void sieve() {

		for (int p = 2; p < n; p++) {
			if (res[p] == 0) {
				for (int j = p; j < n; j += p) {
					res[j] = res[j / p] + 1;
				}
			}
		}
		for (int i = 2; i < n; i++)
			res[i] += res[i - 1];
	}

	static int fact(int a, int b) {

		if (a == 0 || a == 1 || a == b)
			return 1;
		return a * fact(a - 1, b);
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