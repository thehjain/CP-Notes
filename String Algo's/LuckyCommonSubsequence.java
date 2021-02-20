import java.util.*;
import java.io.*;
import java.math.*;

class LuckyCommonSubsequence {

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

		char[] a = sc.next().toCharArray();
		char[] b = sc.next().toCharArray();

		char[] virus = sc.next().toCharArray();

		int[][][] dp = new int[a.length + 1][b.length + 1][virus.length + 1];

		for (int[][] grid : dp)
			for (int[] row : grid)
				Arrays.fill(row, -1);

		int[] suffix = kmp(virus);

		int sol = lps(a, b, virus, a.length - 1, b.length - 1, virus.length - 1, dp, suffix);



	}

	static int lps(char[] a, char[] b, char[] virus, int n, int m, int p, int[][][] dp, int[] suffix) {

		if (p == -1)
			return MAX;
		if (n < 0 || m < 0)
			return 0;
		if (dp[n][m][p] != -1)
			return dp[n][m][p];

		int max = MIN;

		if (a[n] == b[m]) {
			int p2 = p;
			while (p2 < virus.length - 1 && a[n] != virus[p2])
				p2 = suffix[p2 + 1];
			if (a[n] == virus[p1])
				p2--;
			max = 1 + lps(a, b, virus, n - 1, m - 1, p2, dp, suffix);
		}

		return dp[n][m][p] = Math.max(max, Math.max(lps(a, b, virus, n - 1, m, p, dp, suffix), lps(a, b, virus, n, m - 1, p, dp, suffix)));

	}

	static int[] kmp(char[] virus) {

		int n = virus.length - 1;

		int[] lps = new int[v.length];

		lps[n] = n;

		for (int i = v.length - 2; i >= 0; i--) {
			while (n < v.length - 1 && lps[i] != lps[n])
				n = lps[n + 1];
			if (lps[i] == lps[n]) n--;
			lps[i] = n;
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