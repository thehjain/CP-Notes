import java.util.*;
import java.io.*;
import java.math.*;

class NeighborGrid {

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;
	private static int MOD = 1000000007;
	static FastScanner sc = new FastScanner();

	public static void main(String[] args) throws IOException {
		int T = sc.nextInt();
		while (T-- > 0) {
			solve();
		}
	}

	static void solve() throws IOException {

		int n = sc.nextInt();
		int m = sc.nextInt();

		int[][] arr = new int[n][m];

		boolean flag = true;

		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
				if (!isPossible(arr[i][j], i, j, n, m, arr))
					flag = false;
			}

		if (!flag) {
			System.out.println("NO");
			return;
		}

		System.out.println("YES");

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = count(arr[i][j], i, j, n, m, arr);
			}
		}

		for (int[] row : arr) {
			for (int ele : row)
				System.out.print(ele + " ");
			System.out.println();
		}

	}

	static int count(int ele, int i, int j, int n, int m, int[][] arr) {

		int count = 0;

		if (i - 1 >= 0)
			count++;
		if (j - 1 >= 0)
			count++;
		if (i + 1 < n)
			count++;
		if (j + 1 < m)
			count++;

		return count;
	}

	static boolean isPossible(int ele, int i, int j, int n, int m, int[][] arr) {

		int count = 0;

		if (i - 1 >= 0)
			count++;
		if (j - 1 >= 0)
			count++;
		if (i + 1 < n)
			count++;
		if (j + 1 < m)
			count++;

		if (ele <= count)
			return true;

		return false;

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