import java.util.*;
import java.io.*;
import java.math.*;

class MonkAndPower {

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

		Queue<Integer> que = new LinkedList<>();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++)
			que.add(sc.nextInt());
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();

		int total_time = 0, executed = 0;

		while (!que.isEmpty()) {

			int curr = que.poll();

			if (curr == arr[executed]) {
				total_time++;
				executed++;
			} else {
				que.add(curr);
				total_time++;
			}

		}

		System.out.print(total_time);

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