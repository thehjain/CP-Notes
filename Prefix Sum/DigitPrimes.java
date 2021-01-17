import java.util.*;
import java.io.*;
import java.math.*;

class DigitPrimes {

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;
	private static int MOD = 1000000007;
	static FastScanner sc = new FastScanner();

	static boolean[] prime = new boolean[1000001];
	static int[] prefix = new int[1000001];

	public static void main(String[] args) throws IOException {
		int T = sc.nextInt();
		fillPrime();
		fillPre();
		while (T-- > 0) {
			solve();
		}
	}

	static void solve() throws IOException {

		int l = sc.nextInt();
		int r = sc.nextInt();
		System.out.println(prefix[r] - prefix[l]);
	}

	static int digitSum(int i) {
		int sum = 0;
		while (i > 0) {
			sum += i % 10;
			i /= 10;
		}
		return sum;
	}

	static void fillPre() {
		int count = 0;
		for (int i = 1; i < 1000001; i++) {
			if (prime[i] && prime[digitSum(i)])
				count++;
			prefix[i] = count;
		}

	}

	static void fillPrime() {
		Arrays.fill(prime, true);
		int n = 1000001;
		for (int p = 2; p * p < n; p++) {
			if (prime[p] == true) {
				for (int i = p * p; i < n; i += p)
					prime[i] = false;
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