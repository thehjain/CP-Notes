import java.util.*;
import java.io.*;
import java.math.*;

class SHIVIGOD {

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
		int b = sc.nextInt();
		int a = sc.nextInt();

		double[] arr = new double[n];

		for (int i = 0; i < n; i++)
			arr[i] = sc.nextDouble();

		double avg = 0;
		double curr = 0;

		for (int len = a; len <= b; len++) {

			curr = 0;
			for (int i = 0; i < len; i++)
				curr += arr[i];

			avg = Math.max(avg, curr / len);

			for (int i = len; i < n; i++) {
				curr += arr[i];
				curr -= arr[i - len];

				avg = Math.max(avg, curr / len);
			}
		}

		sb.append(String.format("%.06f", avg) + "\n");
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