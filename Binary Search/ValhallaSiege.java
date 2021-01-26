import java.util.*;
import java.io.*;
import java.math.*;

class ValhallaSiege {

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;
	private static int MOD = 1000000007;
	static FastScanner sc = new FastScanner();
	static StringBuilder sb = new StringBuilder();
	static long hits = 0;

	public static void main(String[] args) throws IOException {
		// int T = sc.nextInt();
		// while (T-- > 0) {
		solve();
		System.out.println(sb);
		// }
	}

	static void solve() throws IOException {

		int n = sc.nextInt();
		int q = sc.nextInt();

		long[] arr = new long[n];
		long[] queries = new long[q];

		for (int i = 0; i < n; i++)
			arr[i] = sc.nextLong();

		for (int i = 0; i < q; i++)
			queries[i] = sc.nextLong();

		long[] prefix = new long[n];

		prefix[0] = arr[0];

		for (int i = 1; i < n; i++)
			prefix[i] = prefix[i - 1] + arr[i];

		// for (long ele : prefix)
		// 	System.out.print(ele + " ");

		long d = 0;

		for (long arrows : queries) {

			d += arrows;
			// System.out.println(d);
			if (d >= prefix[n - 1]) d = 0;

			int standing = binarySearch(prefix, d);
			// System.out.println(standing);
			int res = n - standing;
			sb.append(res + "\n");
		}

	}

	static int binarySearch(long[] prefix, long d) {

		int start = 0;
		int end = prefix.length - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (prefix[mid] > d) {
				end = mid - 1;
			} else
				start = mid + 1;
		}
		return start;
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