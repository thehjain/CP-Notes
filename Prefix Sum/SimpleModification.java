import java.util.*;
import java.io.*;
import java.math.*;

class SimpleModification {

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
		int m = sc.nextInt();

		int modifications = sc.nextInt();
		int queries = sc.nextInt();

		int[][] arr = new int[n][m];
		int[][] temp = new int[n][m];

		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				arr[i][j] = sc.nextInt();

		for (int i = 0; i < modifications; i++) {

			int k = sc.nextInt();

			int r1 = sc.nextInt();
			int c1 = sc.nextInt();
			int r2 = sc.nextInt();
			int c2 = sc.nextInt();

			temp[r1][c1] += k;
			if (r2 + 1 < n) {
				temp[r2 + 1][c1] -= k;
			}
			if (c2 + 1 < m) {
				temp[r1][c2 + 1] -= k;
			}
			if (r2 + 1 < n && c2 + 1 < m) {
				temp[r2 + 1][c2 + 1] += k;
			}
		}

		for (int i = 0; i < n; i++) {
			if (i != 0)
				temp[i][0] = temp[i][0] + temp[i - 1][m - 1];
			for (int j = 1; j < m; j++) {
				temp[i][j] += temp[i][j - 1];
			}
		}

		for (int[] row : temp) {
			for (int ele : row)
				System.out.print(ele + " ");
			System.out.println();
		}

		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				arr[i][j] += temp[i][j];

		for (int i = 0; i < n; i++) {
			if (i != 0)
				arr[i][0] = arr[i][0] + arr[i - 1][m - 1];
			for (int j = 1; j < m; j++) {
				arr[i][j] += arr[i][j - 1];
			}
		}

		for (int[] row : arr) {
			for (int ele : row)
				System.out.print(ele + " ");
			System.out.println();
		}

		for (int i = 0; i < queries; i++) {

			int r1 = sc.nextInt();
			int c1 = sc.nextInt();
			int r2 = sc.nextInt();
			int c2 = sc.nextInt();

			System.out.println(arr[r2][c2] - arr[r1][c1]);

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