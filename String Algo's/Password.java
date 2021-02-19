import java.util.*;
import java.io.*;
import java.math.*;

class Password {

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

		String s = sc.next();

		int[] arr = lps(s);

		int n = s.length();

		int end = arr[n - 1];

		if (end == 0) {
			System.out.print("Just a legend");
			return;
		}

		boolean flag = false;

		for (int i = 1; i < n - 1; i++) {
			if (arr[i] == end) {
				flag = true;
				break;
			}
		}

		if (flag)
			System.out.print(s.substring(0, end));
		else {
			end = arr[end - 1];
			if (end == 0)
				System.out.print("Just a legend");
			else
				System.out.print(s.substring(0, end));
		}

	}

	static int[] lps(String s) {

		int n = s.length();
		int[] a = new int[n];

		for (int i = 1; i < n; i++) {
			int j = a[i - 1];
			while (j > 0 && s.charAt(i) != s.charAt(j))
				j = a[j - 1];
			if (s.charAt(i) == s.charAt(j))
				j++;
			a[i] = j;
		}

		return a;

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