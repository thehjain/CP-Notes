import java.util.*;
import java.io.*;
import java.math.*;

class INSQ15_A {

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;
	private static int MOD = 1000000007;
	static FastScanner sc = new FastScanner();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// int T = sc.nextInt();
		// while (T-- > 0) {
		solve();
		// }
	}

	static void solve() throws IOException {

		String s = sc.next();

		int q = sc.nextInt();

		int[] lps = ZFunction(s);

		while (q-- > 0) {

			int n = sc.nextInt();

			sb.append(Math.min(n, lps[n]) + "\n");

		}

		System.out.print(sb);

	}

	static int[] ZFunction(String s) {

		int l = 0, r = 0;
		int[] lps = new int[s.length()];

		int n = s.length();

		for (int i = 1; i < n; i++) {
			if (i > r) {
				l = r = i;
				while (r < n && s.charAt(r) == s.charAt(r - l))
					r++;
				lps[i] = r - l;
				r--;
			} else {
				int k = i - l;
				if (lps[k] < r - i + 1) {
					lps[i] = lps[k];
				} else {
					l = i;
					while (r < n && s.charAt(r) == s.charAt(r - l))
						r++;
					lps[i] = r - l;
					r--;
				}
			}
		}
		return lps;
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