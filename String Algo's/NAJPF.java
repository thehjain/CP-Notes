import java.util.*;
import java.io.*;
import java.math.*;

class NAJPF {

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;
	private static int MOD = 1000000007;
	static FastScanner sc = new FastScanner();
	static StringBuilder sb = new StringBuilder();
	static int[] pattern;

	public static void main(String[] args) throws IOException {
		int T = sc.nextInt();
		while (T-- > 0) {
			solve();
		}
		System.out.print(sb);
	}

	static void solve() throws IOException {

		String[] input = sc.nextLine().trim().split(" ");

		kmp(input[1]);
		kmpUtil(input[0], input[1]);

	}

	static void kmpUtil(String text, String patt) {

		boolean flag = false;

		int len = text.length();
		int m = patt.length();

		StringBuilder temp = new StringBuilder();

		int i = 0, j = 0;
		int count = 0;

		while (i < len) {

			if (patt.charAt(j) == text.charAt(i)) {
				i++;
				j++;

				if (j == m) {
					count++;
					temp.append(i - m + 1 + " ");
					j = pattern[j];
					flag = true;
				}
			} else if (j > 0)
				j = pattern[j];
			else
				i++;


		}

		if (!flag)
			sb.append("Not Found\n");
		else {
			sb.append(count + "\n");
			sb.append(temp + "\n");
		}

	}

	static void kmp(String patt) {

		pattern = new int[patt.length() + 1];

		pattern[0] = 0;
		pattern[1] = 0;

		for (int i = 2; i <= patt.length(); i++) {
			int j = pattern[i - 1];
			while (true) {
				if (patt.charAt(j) == patt.charAt(i - 1)) {
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