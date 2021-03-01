import java.util.*;
import java.io.*;
import java.math.*;

class AntonAndTree {

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;
	private static int MOD = 1000000007;
	static FastScanner sc = new FastScanner();
	static int max;
	static int maxN;
	static HashMap<Integer, Integer> map;
	static ArrayList<ArrayList<Integer>> arr;

	public static void main(String[] args) throws IOException {
		// int T = sc.nextInt();
		// while (T-- > 0) {
		solve();
		// }
	}

	static void solve() throws IOException {

		int n = sc.nextInt();

		map = new HashMap<>();
		arr = new ArrayList<>();

		for (int i = 0; i <= n; i++)
			arr.add(new ArrayList<>());

		//0 for black and 1 for white

		for (int i = 1; i <= n; i++) {
			map.put(i, sc.nextInt());
		}

		for (int i = 1; i < n; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			arr.get(u).add(v);
			arr.get(v).add(u);
		}

		max = 0;
		maxN = 0;

		dfs(1, 1, 0);

		max = 0;

		dfs(maxN, maxN, 0);

		System.out.print((max + 1) / 2);

	}

	static void dfs(int v, int pre, int depth) {
		if (depth > max) {
			max = depth;
			maxN = v;
		}
		for (int ele : arr.get(v)) {
			if (ele != pre)
				dfs(ele, v, depth + ((map.get(v) == map.get(ele)) ? 0 : 1));
		}
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