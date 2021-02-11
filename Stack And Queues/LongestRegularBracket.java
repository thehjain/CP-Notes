import java.util.*;
import java.io.*;
import java.math.*;

class LongestRegularBracket {

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

		int max = 0;
		int freq = 1;

		Stack<Integer> st = new Stack<>();

		st.push(-1);

		for (int i = 0; i < s.length(); i++) {

			char curr = s.charAt(i);

			if (curr == '(')
				st.push(i);
			else {
				st.pop();
				if (!st.isEmpty()) {
					int c = i - st.peek();
					if (c > max) {
						max = c;
						freq = 1;
					} else if (c == max)
						freq++;
				} else
					st.push(i);
			}

		}

		System.out.print(max + " " + freq);

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