import java.util.*;
import java.io.*;
import java.math.*;

class RUNNING {

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;
	private static int MOD = 1000000007;
	static FastScanner sc = new FastScanner();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int T = sc.nextInt();
		while (T-- > 0) {
			solve();
		}
		System.out.print(sb);
	}

	static void solve() throws IOException {

		int n = sc.nextInt();
		int k = sc.nextInt();

		int[] arr = new int[n - 1];

		int prev = sc.nextInt();

		for (int i = 0; i < n - 1; i++) {
			arr[i] = sc.nextInt() - prev;
			prev += arr[i];
		}

		int[] brr = new int[k];

		for (int i = 0; i < k; i++)
			brr[i] = sc.nextInt();

		int[] lps = lps(brr);

		int curr = 0, res = 0;

		for (int i = 0; i < arr.length;) {
			if (arr[i] == brr[curr]) {
				curr++; i++;
				if (curr == brr.length) {
					res++;
					curr = lps[curr - 1];
				}
			} else if (curr > 0) {
				curr = lps[curr - 1];
			} else
				i++;
		}

		sb.append(res + "\n");

	}

	static int[] lps(int[] brr) {

		int[] lps = new int[brr.length];

		int pos = 1, len = 0;

		while (pos < brr.length) {
			if (brr[pos] == brr[len]) {
				lps[pos++] = ++len;
			} else if (len > 0) {
				len = lps[len - 1];
			} else
				pos++;
		}
		return lps;
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