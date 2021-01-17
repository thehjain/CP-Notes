import java.util.*;
import java.io.*;
import java.math.*;

class OrInMatrix {

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

		int[][] arr = new int[n][m];
		int[][] b = new int[n][m];
		int[][] c = new int[n][m];

		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				b[i][j] = sc.nextInt();

		for (int[] row : arr)
			Arrays.fill(row, 1);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (b[i][j] == 0) {
					for (int k = 0; k < n; k++) {
						arr[k][j] = 0;
					}
					for (int k = 0; k < m; k++)
						arr[i][k] = 0;
				}
			}
		}

		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 1) {
					for (int k = 0; k < n; k++)
						c[k][j] = 1;
					for (int k = 0; k < m; k++)
						c[i][k] = 1;
				}
			}

		boolean flag = true;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++)
				if (b[i][j] != c[i][j]) {
					flag = false;
					break;
				}
			if (!flag)
				break;
		}

		if (flag) {
			System.out.println("YES");
			for (int[] row : arr) {
				for (int ele : row)
					System.out.print(ele + " ");
				System.out.println();
			}
		} else
			System.out.println("NO");

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