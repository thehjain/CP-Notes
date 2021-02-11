import java.util.*;
import java.io.*;
import java.math.*;

class THESAV {

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

		char[] arr = sc.next().toCharArray();

		Queue<Character> que = new LinkedList<>();

		for (char ele : arr)
			que.add(ele);

		if (arr[0] == '0') {
			System.out.println("NO");
			return;
		}

		int count = 2;

		while (!que.isEmpty()) {

			char temp = que.poll();

			if (temp == '0') {
				count--;
				if (count < 0) {
					System.out.println("NO");
					return;
				}
			} else
				count = 2;

		}

		System.out.println("YES");

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