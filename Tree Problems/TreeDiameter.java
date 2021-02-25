import java.util.*;
import java.io.*;
import java.math.*;

class TreeDiameter {

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;
	private static int MOD = 1000000007;
	static FastScanner sc = new FastScanner();
	static int d = 0;
	static int[] diameter = new int[1000001];

	public static void main(String[] args) throws IOException {
		// int T = sc.nextInt();
		// while (T-- > 0) {
		solve();
		// }
	}

	static void solve() throws IOException {

		int n = sc.nextInt();

		ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

		for (int i = 0; i <= n; i++) {
			arr.add(new ArrayList<>());
		}

		for (int i = 1; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr.get(a).add(b);
			arr.get(b).add(a);
		}

		int node = bfs(1, arr, n);
		int res = bfs(node, arr, n);

		System.out.print(diameter[res]);

	}

	static int bfs(int node, ArrayList<ArrayList<Integer>> arr, int n) {

		Queue<Integer> que = new LinkedList<>();
		que.add(node);

		boolean[] visited = new boolean[n + 1];

		for (int i = 0; i <= n; i++)
			diameter[i] = 0;

		que.add(node);
		visited[node] = true;
		while (!que.isEmpty()) {

			int curr = que.poll();

			for (int i = 0; i < arr.get(curr).size(); i++) {
				if (visited[arr.get(curr).get(i)]) continue;
				visited[arr.get(curr).get(i)] = true;
				diameter[arr.get(curr).get(i)] += 1 + diameter[curr];
				que.add(arr.get(curr).get(i));
			}

		}

		int res = 0;

		for (int i = 1; i <= n; i++) {
			if (diameter[i] > diameter[res])
				res = i;
		}

		return res;

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