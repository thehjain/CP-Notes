import java.util.*;
import java.io.*;
import java.math.*;

class MXPOWER {

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;
	private static int MOD = 1000000007;
	static FastScanner sc = new FastScanner();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int T = sc.nextInt();
		while (T-- > 0) {
			solve();
		}
		System.out.println(sb);
	}

	static void solve() throws IOException {

		int n = sc.nextInt();

		int[][] arr = new int[n][n];

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				arr[i][j] = sc.nextInt();

		int res = MIN;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				int sum = arr[i][j];
				res = Math.max(sum, res);

				for (int k = 1; i + k < n && j + k < n && i - k >= 0 && j - k >= 0; k++) {

					sum += arr[i][j - k];
					sum += arr[i][j + k];
					sum += arr[i - k][j];
					sum += arr[i + k][j];

					for (int l = 1; l < k; l++) {

						sum += arr[i - l][j - k + l];
						sum += arr[i + l][j - k + l];
						sum += arr[i - l][j + k - l];
						sum += arr[i + l][j + k - l];

					}
					res = Math.max(sum, res);
				}

			}
		}
		sb.append(res + "\n");
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