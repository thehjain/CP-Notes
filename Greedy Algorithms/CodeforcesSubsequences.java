import java.util.*;
import java.io.*;
import java.math.*;

class CodeforcesSubsequences {

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

		long n = sc.nextLong();

		long temp = 1;

		String s = "codeforces";

		StringBuilder sb = new StringBuilder();

		int[] arr = new int[10];
		int index = 0;

		Arrays.fill(arr, 1);

		while (temp < n) {
			if (index == 10)
				index = 0;
			temp /= arr[index];
			arr[index]++;
			temp *= arr[index];
			index++;
		}

		for (int i = 0; i < 10; i++)
			for (int j = 0; j < arr[i]; j++)
				sb.append(s.charAt(i));

		System.out.print(sb);

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