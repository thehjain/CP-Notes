import java.util.*;
import java.io.*;
import java.math.*;

class CSUMQ {

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;
	private static int MOD = 1000000007;
	static FastScanner sc = new FastScanner();

	public static void main(String[] args) throws IOException {
		// int T = sc.nextInt();
		// while (T-- > 0) {
		solve();
		// }
	}

	static void solve() throws IOException {

		int n = sc.nextInt();

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			if (i == 0)
				arr[i] = sc.nextInt();
			else {
				arr[i] = sc.nextInt();
				arr[i] += arr[i - 1];
			}
		}

		int q = sc.nextInt();

		while (q-- > 0) {

			int l = sc.nextInt();
			int r = sc.nextInt();

			if (l == 0) {
				System.out.println(arr[r]);
				continue;
			}

			else {
				System.out.println(arr[r] - arr[l - 1]);
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