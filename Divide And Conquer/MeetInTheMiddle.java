import java.util.*;
import java.io.*;
import java.math.*;

class Pair {
	int n;
	long sum;
	Pair(int n, long sum) {
		this.n = n;
		this.sum = sum;
	}
}

class MeetInTheMiddle {

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;
	private static int MOD = 1000000007;
	static FastScanner sc = new FastScanner();
	static HashMap<Pair, Long> map = new HashMap<>();

	public static void main(String[] args) throws IOException {
		// int T = sc.nextInt();
		// while (T-- > 0) {
		solve();
		// }
	}

	static void solve() throws IOException {

		int n = sc.nextInt();

		long sum = sc.nextLong();

		long[] arr = new long[n];

		for (int i = 0; i < n; i++)
			arr[i] = sc.nextLong();

		long count = countWays(arr, n, 0, sum);

		// System.out.println(map.size());

		System.out.print(count);

	}

	static long countWays(long[] arr, int n, long curr, long sum) {

		if (n == 0) {
			if (curr == sum)
				return 1;
			else
				return 0;
		}
		if (sum == curr)
			return 1;
		if (curr > sum)
			return 0;

		if (map.containsKey(new Pair(n, curr))) {
			System.out.println("helo");
			return map.get(new Pair(n, curr));
		}

		if (arr[n - 1] + curr <= sum) {
			long temp = countWays(arr, n - 1, curr + arr[n - 1], sum) + countWays(arr, n - 1, curr, sum);
			map.put(new Pair(n, curr), temp);
			return temp;
		} else {
			long temp = countWays(arr, n - 1, curr, sum);
			map.put(new Pair(n, curr), temp);
			return temp;
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