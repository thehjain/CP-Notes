import java.util.*;
import java.io.*;
import java.math.*;

class Pair {
	int a;
	int b;
	Pair(int a, int b) {
		this.a = a;
		this.b = b;
	}
}

class SwapLetters {

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;
	private static int MOD = 1000000007;
	static FastScanner sc = new FastScanner();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// int T = sc.nextInt();
		// while (T-- > 0) {
		solve();
		// }
		System.out.print(sb);
	}

	static void solve() throws IOException {

		int n = sc.nextInt();

		char[] s = sc.next().toCharArray();
		char[] t = sc.next().toCharArray();

		ArrayList<Integer> arr = new ArrayList<>();
		ArrayList<Integer> brr = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			if (s[i] != t[i]) {
				if (s[i] == 'a')
					arr.add(i + 1);
				else
					brr.add(i + 1);
			}
		}

		if ((arr.size() + brr.size()) % 2 == 1) {
			sb.append("-1\n");
			return;
		}

		int count = 0;

		for (int i = 0; i < arr.size() - arr.size() % 2; i += 2, count++)
			sb.append(arr.get(i) + " " + arr.get(i + 1) + "\n");
		for (int i = 0; i < brr.size() - brr.size() % 2; i += 2, count++)
			sb.append(brr.get(i) + " " + brr.get(i + 1) + "\n");
		if (arr.size() % 2 == 1) {
			count += 2;
			sb.append(arr.get(arr.size() - 1) + " " + arr.get(arr.size() - 1) + "\n");
			sb.append(arr.get(arr.size() - 1) + " " + brr.get(brr.size() - 1) + "\n");
		}
		System.out.println(count);
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