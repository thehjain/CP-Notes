import java.util.*;
import java.io.*;
import java.math.*;

class COWA19B {

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

		long[] arr = new long[n + 2];
		long[] arr2 = new long[n + 2];

		int modifications = sc.nextInt();

		for (int i = 0; i < modifications; i++) {
			int l = sc.nextInt();
			int r = sc.nextInt();

			arr[l]++;
			arr[r + 1]--;
			arr2[r + 1] -= (r - l + 1);

		}

		for (int i = 1; i <= n; i++) {
			arr[i] = arr[i - 1] + arr[i];
			arr2[i] += arr2[i - 1] + arr[i];
		}

		int queries = sc.nextInt();

		for (int i = 0; i < queries; i++) {
			int index = sc.nextInt();
			System.out.println(arr2[index]);
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