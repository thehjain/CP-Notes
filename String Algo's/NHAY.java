import java.util.*;
import java.io.*;
import java.math.*;

class NHAY {

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;
	private static int MOD = 1000000007;
	static FastScanner sc = new FastScanner();
	static StringBuilder sb = new StringBuilder();
	static int[] pattern;

	public static void main(String[] args) throws IOException {
		// int T = sc.nextInt();
		while (true) {
			String s = sc.nextLine();
			if (s == null)
				break;
			String needle = sc.nextLine();
			String hayStack = sc.nextLine();
			solve(s, needle, hayStack);
		}
		System.out.print(sb);
	}

	static void solve(String s, String needle, String hayStack) throws IOException {

		int n = Integer.parseInt(s);

		build(needle);

		boolean flag = false;

		int len = hayStack.length();



		int i = 0, j = 0;

		while (i < len) {
			if (needle.charAt(j) == hayStack.charAt(i)) {
				i++;
				j++;
				if (j == n ) {
					sb.append((i - n) + "\n");
					j = pattern[j];
					flag = true;
				}
			} else if (j > 0) {
				j = pattern[j];
			} else
				i++;
		}
		if (!flag)
			sb.append("\n");

	}

	static void build(String needle) {

		pattern = new int[10000];

		pattern[0] = pattern[1] = 0;

		for (int i = 2; i <= needle.length(); i++) {
			int j = pattern[i - 1];
			while (true) {
				if (needle.charAt(j) == needle.charAt(i - 1)) {
					pattern[i] = j + 1;
					break;
				}
				if (j == 0) {
					pattern[i] = 0;
					break;
				}
				j = pattern[j];
			}
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