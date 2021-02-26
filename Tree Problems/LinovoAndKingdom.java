import java.util.*;
import java.io.*;
import java.math.*;

class LinovoAndKingdom {

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;
	private static int MOD = 1000000007;
	static FastScanner sc = new FastScanner();
	static int n, k;
	static ArrayDeque<Integer>[] edges;
	static int[] h, size;

	public static void main(String[] args) throws IOException {
		// int T = sc.nextInt();
		// while (T-- > 0) {
		solve();
		// }
	}

	static void solve() throws IOException {

		int n = sc.nextInt();
		int k = sc.nextInt();

		edges = new ArrayDeque[n];

		for (int i = 0; i < n; i++)
			edges[i] = new ArrayDeque<>();

		for (int i = 0; i < n - 1; ++i) {
			int a = sc.nextInt() - 1, b = sc.nextInt() - 1;
			edges[a].add(b);
			edges[b].add(a);
		}

		h = new int[n];
		size = new int[n];

		Integer[] val = new Integer[n];

		dfs(0, -1);

		for (int i = 0; i < n; i++)
			val[i] = h[i] - (size[i] - 1);

		Arrays.sort(val);

		long res = 0;

		for (int i = 0; i < k; i++) {
			// System.out.print(val[i] + " ");
			res += val[n - 1 - i];
		}

		System.out.print(res);

	}

	static int dfs(int node, int parent) {

		int out = 1;

		for (int ele : edges[node]) {
			if (ele != parent) {
				h[ele] = h[node] + 1;
				out += dfs(ele, node);
			}
		}

		return size[node] = out;

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