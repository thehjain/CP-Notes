import java.util.*;
import java.io.*;
import java.math.*;

class SpecialNumbers {

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;
	private static int MOD = 1000000007;
	static FastScanner sc = new FastScanner();
	static StringBuilder sb = new StringBuilder();
	static int p;
	static int[] res = new int[10000001];

	public static void main(String[] args) throws IOException {
		p = sc.nextInt();
		int T = sc.nextInt();
		sieve();
		while (T-- > 0) {
			solve();
		}
		System.out.print(sb);
	}

	static void solve() throws IOException {
		int n = sc.nextInt();
		// System.out.println(res[n]);
		if (res[n] >= p)
			sb.append("YES" + "\n");
		else
			sb.append("NO" + "\n");
	}

	static void sieve() {
		int n = 10000001;
		boolean[] isPrime = new boolean[10000001];
		Arrays.fill(isPrime, true);

		for (int p = 2; p < n; p++) {
			if (isPrime[p]) {
				res[p]++;
				for (int i = p + p; i < n; i += p) {
					isPrime[i] = false;
					res[i]++;
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