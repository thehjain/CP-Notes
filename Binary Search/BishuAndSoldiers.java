import java.util.*;
import java.io.*;
import java.math.*;

class BishuAndSoldiers {

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;
	private static int MOD = 1000000007;
	static FastScanner sc = new FastScanner();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// int T = sc.nextInt();
		// while (T-- > 0) {
		solve();
		System.out.println(sb);
		// }
	}

	static void solve() throws IOException {

		int n = sc.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();

		int no_of_queries = sc.nextInt();

		Arrays.sort(arr);

		long[] prefix = new long[n];

		prefix[0] = arr[0];

		for (int i = 1; i < n; i++)
			prefix[i] = prefix[i - 1] + arr[i];

		while (no_of_queries-- > 0) {

			int power = sc.nextInt();

			int index = binarSearch(arr, power);

			// System.out.println(index);
			if (index == 0)
				sb.append(0 + " " + 0 + "\n");
			else
				sb.append(index + " " + prefix[index - 1] + "\n");

		}

	}

	static int binarSearch(int[] arr, int power) {
		int low = 0, high = arr.length;
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] <= power)
				low = mid + 1;
			else
				high = mid;
		}
		return low;
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