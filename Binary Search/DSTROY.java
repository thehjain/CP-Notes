import java.util.*;
import java.io.*;
import java.math.*;

class DSTROY {

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

		long[] arr = new long[n];
		long sum = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextLong();
			sum += arr[i];
		}

		long start = 0;
		long end = sum;
		long res = 0;

		while (start <= end) {
			long temp = 0;
			long mid = start + (end - start) / 2;
			for (long ele : arr)
				temp += Math.min(ele, mid);
			if ((temp / mid) >= k) {
				start = mid + 1;
				res = mid;
			} else
				end = mid - 1;
		}

		System.out.println(res);
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