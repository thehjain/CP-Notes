import java.util.*;
import java.io.*;
import java.math.*;

class ANARC09A {

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;
	private static int MOD = 1000000007;
	static FastScanner sc = new FastScanner();

	public static void main(String[] args) throws IOException {
		// int T = sc.nextInt();
		int test = 1;
		while (true) {
			String s = sc.next();
			if (s.charAt(0) == '-')
				break;
			solve(s, test++);
		}
	}

	static void solve(String s, int test) throws IOException {

		char[] arr = s.toCharArray();

		Stack<Character> st = new Stack<>();

		int count = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '{')
				st.push(arr[i]);
			else {
				if (!st.isEmpty())
					st.pop();
				else {
					count++;
					st.push('{');
				}
			}
		}
		System.out.println(test + ". " + (count + st.size() / 2));
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