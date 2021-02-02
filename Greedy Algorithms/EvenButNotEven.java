import java.util.*;
import java.io.*;
import java.math.*;

class EvenButNotEven {

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;
	private static int MOD = 1000000007;
	static FastScanner sc = new FastScanner();

	public static void main(String[] args) throws IOException {
		int T = sc.nextInt();
		while (T-- > 0) {
			solve();
		}
	}

	static void solve() throws IOException {

		int n = sc.nextInt();

		char[] arr = sc.next().toCharArray();

		String r = "";
		int sum = 0;

		int[] ar = new int[n];
		int index = 0;
		for (char ele : arr)
			ar[index++] = ele - '0';

		for (int ele : ar) {

			if (ele % 2 == 0)
				continue;

			r += ele;
			sum += ele;
			if (sum % 2 == 0)
				break;

		}
		if (sum % 2 == 0 && sum > 0)
			System.out.println(r);
		else
			System.out.println(-1);

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