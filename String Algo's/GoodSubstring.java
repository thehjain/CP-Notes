
//Rabin karp Algo is used in this Problem

import java.util.*;
import java.io.*;
import java.math.*;

class GoodSubstring {

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

		String s = sc.next();
		char[] arr = sc.next().toCharArray();
		int k = sc.nextInt();

		Set<Long> set = new HashSet<>();

		int base = 29;

		for (int i = 0; i < s.length(); i++) {
			long hash = 0;
			for (int j = i, bad = 0; j >= 0; j--) {
				hash = hash * base + s.charAt(j) - 'a' + 1;
				bad += (arr[s.charAt(j) - 'a'] == '0') ? 1 : 0;
				if (bad <= k)
					set.add(hash);
				else
					break;
			}
		}

		System.out.print(set.size());

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