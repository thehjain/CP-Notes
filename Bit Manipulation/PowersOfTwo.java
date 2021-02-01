import java.util.*;
import java.io.*;
import java.math.*;

class PowersOfTwo {

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

		if (k > n) {
			System.out.println("NO");
			return;
		}
		if (k == n) {
			System.out.println("YES");
			for (int i = 0; i < n; i++)
				System.out.print(1 + " ");
			return;
		}

		if (k == 1) {
			if (isPower(n)) {
				System.out.println("YES");
				System.out.print(n);
			} else
				System.out.println("NO");
			return;
		}

		int[] arr = new int[k];
		int temp = k;

		for (int i = 0; i < k; i++) {
			arr[i] = 1;
			while (temp + arr[i] <= n) {
				temp += arr[i];
				arr[i] *= 2;
			}
		}

		if (temp != n) {
			System.out.println("NO");
			return;
		}

		System.out.println("YES");

		for (int i = 0; i < k; i++)
			System.out.print(arr[i] + " ");

	}

	static boolean isPower(int n) {
		return n != 0 && ((n & (n - 1)) == 0);
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