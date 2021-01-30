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

class SwapSort {

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

		ArrayList<Pair> ar = new ArrayList<>();

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		int count = 0;

		for (int i = 0; i < n; i++) {
			int temp = i;
			for (int j = i; j < n; j++) {
				if (arr[temp] > arr[j]) {
					temp = j;
				}
			}
			if (temp != i) {
				count++;
				ar.add(new Pair(i, temp));
				int curr = arr[i];
				arr[i] = arr[temp];
				arr[temp] = curr;
			}
		}

		System.out.println(count);
		for (Pair ele : ar)
			System.out.println(ele.a + " " + ele.b);

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