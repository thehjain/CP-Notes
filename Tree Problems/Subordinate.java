import java.util.*;
import java.io.*;
import java.math.*;

class Subordinate {

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;
	private static int MOD = 1000000007;
	static FastScanner sc = new FastScanner();
	static int count = 0;

	public static void main(String[] args) throws IOException {
		// int T = sc.nextInt();
		// while (T-- > 0) {
		solve();
		// }
	}

	static void solve() throws IOException {

		int n = sc.nextInt();

		ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

		int[] res = new int[n + 1];

		for (int i = 0; i <= n; i++)
			arr.add(new ArrayList<>());

		for (int i = 2; i <= n; i++) {
			int temp = sc.nextInt();
			arr.get(temp).add(i);
			arr.get(i).add(temp);
		}

		dfs(arr, 1, 0, res);

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= n; i++)
			sb.append(res[i] + " ");

		System.out.print(sb);

	}

	static void dfs(ArrayList<ArrayList<Integer>> arr, int node, int parent, int[] res) {

		int sub = 0;

		for (int ele : arr.get(node)) {
			if (ele != parent) {
				dfs(arr, ele, node, res);
				sub += (1 + res[ele]);
			}
		}
		res[node] = sub;
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