import java.util.*;
import java.io.*;
import java.math.*;

class KJ {

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
		int p = sc.nextInt();

		int[] count = new int[p + 1];

		for (int i = 0; i < n; i++) {
			int point = sc.nextInt();
			int strength = sc.nextInt();
			if (strength == 0) {
				count[point]++;
				if (point < p)
					count[point + 1]--;
				continue;
			}
			if (point - strength < 0)
				count[0]++;
			else
				count[point - strength]++;
			if (point + strength < p)
				count[point + strength + 1]--;
		}

		int max = 0;
		int curr = 0;

		for (int i = 1; i <= p; i++)
			count[i] += count[i - 1];

		for (int ele : count) {
			System.out.print(ele + " ");
			if (ele != 1) {
				curr++;
			} else {
				max = Math.max(max, curr);
				curr = 0;
			}
		}
		System.out.println(Math.max(curr, max));
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