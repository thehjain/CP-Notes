import java.util.*;
import java.io.*;
import java.math.*;

class SUMPOWER {

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;
	private static int MOD = 1000000007;
	static FastScanner sc = new FastScanner();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int T = sc.nextInt();
		while (T-- > 0) {
			solve();
		}
		System.out.println(sb);
	}

	static void solve() throws IOException {

		int n = sc.nextInt();
		int k = sc.nextInt();

		char[] arr = sc.next().toCharArray();

		int count = 1;
		long res = 0;

		for (int i = 1; i < k; i++)
			if (arr[i] != arr[i - 1]) count++;

		for (int i = k; i < n; i++) {
			res += count;
			if (arr[i] == arr[i - 1]) res--;
			else count++;
			if (arr[i - k] != arr[i - k + 1]) count--;
		}

		sb.append(res + "\n");
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