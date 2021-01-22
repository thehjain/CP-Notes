import java.util.*;
import java.io.*;
import java.math.*;

class Fence {

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
		int k = sc.nextInt();

		int[] arr = new int[n];

		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();

		if (n == 1) {
			System.out.println(1);
			return;
		}

		long sum = 0;
		long curr = 0;
		int index = 1;

		for (int i = 0; i < k; i++)
			sum += arr[i];

		curr = sum;

		// System.out.println(sum);

		for (int i = k; i < n; i++) {
			// System.out.print(curr + " ");
			curr += arr[i];
			curr -= arr[i - k];
			// System.out.println(curr);
			if (curr < sum) {
				index = i - k + 2;
				sum = curr;
			}
		}

		System.out.println(index);

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