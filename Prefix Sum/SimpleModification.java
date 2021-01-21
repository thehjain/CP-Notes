

//This problem is based on difference array and prefix sum both

//this solution is working and passing all test cases but this
//is not the most optimal solution.


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

		long[][] arr = new long[n][m];
		long[][] diff = new long[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = sc.nextLong();
				if (j == 0)
					diff[i][j] = arr[i][j];
				else
					diff[i][j] = arr[i][j] - arr[i][j - 1];
			}
		}

		for (int j = 0; j < modifications; j++) {

			long k = sc.nextLong();

			int r1 = sc.nextInt();
			int c1 = sc.nextInt();
			int r2 = sc.nextInt();
			int c2 = sc.nextInt();

			for (int i = r1; i <= r2; i++) {
				diff[i][c1] += k;
				if (c2 < m - 1)
					diff[i][c2 + 1] -= k;
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (j == 0)
					arr[i][j] = diff[i][j];
				else
					arr[i][j] = diff[i][j] + arr[i][j - 1];
			}
		}

		// for (int[] row : arr) {
		// 	for (int ele : row)
		// 		System.out.print(ele + " ");
		// 	System.out.println();
		// }

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (j == 0)
					continue;
				arr[i][j] += arr[i][j - 1];
			}
		}

		// for (int[] row : arr) {
		// 	for (int ele : row)
		// 		System.out.print(ele + " ");
		// 	System.out.println();
		// }

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < queries; i++) {

			int r1 = sc.nextInt();
			int c1 = sc.nextInt();
			int r2 = sc.nextInt();
			int c2 = sc.nextInt();

			long sum = 0;

			for (int j = r1; j <= r2; j++) {
				if (c1 > 0)
					sum += arr[j][c2] - arr[j][c1 - 1];
				else
					sum += arr[j][c2];
			}

			sb.append(sum + "\n");

		}

		System.out.println(sb);

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