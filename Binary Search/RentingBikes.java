import java.util.*;
import java.io.*;
import java.math.*;

public class RentingBikes {

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;
	private static int MOD = 1000000007;
	static FastScanner sc = new FastScanner();

	public static void main(String[] args) throws IOException {
// 		int T = sc.nextInt();
// 		while (T-- > 0) {
		solve();
// 		}
	}

	static void solve() throws IOException {

		int n = sc.nextInt();
		int m = sc.nextInt();
		long a = sc.nextLong();

		long[] boys = new long[n + 2];
		long[] bikes = new long[m + 2];

		for (int i = 1; i <= n; i++)
			boys[i] = sc.nextLong();
		for (int i = 1; i <= m; i++)
			bikes[i] = sc.nextLong();

		Arrays.sort(boys, 1, n + 1);
		Arrays.sort(bikes, 1, m + 1);

		int low = 1, high = Math.min(n, m);
		long ans = 0;

		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (check(boys, bikes, mid) <= a) {
				ans = mid;
				low = mid + 1;
			} else
				high = mid - 1;
		}
		long sum = 0;

		for (int i = 1; i <= ans; i++)
			sum += bikes[i];

		long res = sum - a;

		if (res <= 0)
			res = 0;

		System.out.println(ans + " " + res);
	}

	static long check(long[] boys, long[] bikes, int mid) {
		long sum = 0;
		int n = boys.length - 2;
		for (int i = mid; i >= 1; i--) {
			if (boys[n - mid + i] < bikes[i]) {
				sum += bikes[i] - boys[n - mid + i];
			}
		}
		return sum;
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