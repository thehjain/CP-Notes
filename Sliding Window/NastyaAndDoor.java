import java.util.*;
import java.io.*;
import java.math.*;

class NastyaAndDoor {

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

		int[] arr = new int[n + 1];

		for (int i = 1; i <= n; i++)
			arr[i] = sc.nextInt();

		boolean[] peek = new boolean[n + 1];

		for (int i = 2; i < n ; i++)
			if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1])
				peek[i] = true;

		int resIndex = 1;
		int resParts = 0;
		int countPeeks = 0;

		for (int i = 2; i < k ; i++) {
			if (peek[i]) countPeeks++;
		}

		resParts = countPeeks;
		// int lastCount = countPeeks;

		for (int i = k + 1; i <= n; i++) {
			int lastCount = countPeeks;
			if (peek[i - k + 1]) lastCount--;
			if (peek[i - 1]) lastCount++;
			if (resParts < lastCount) {
				resIndex = i - k + 1;
				resParts = lastCount;
			}
			countPeeks = lastCount;
		}

		sb.append((resParts + 1) + " " + resIndex + "\n");

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