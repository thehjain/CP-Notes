import java.util.*;
import java.io.*;
import java.math.*;

class Main {

	static class Pair {
		int x, y, dist, charValue;
		Pair(int x, int y, int dist, int charValue) {
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.charValue = charValue;
		}
	}

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;
	private static int MOD = 1000000007;
	static FastScanner sc = new FastScanner();
	static StringBuilder sb = new StringBuilder();
	static int[] X = { -1, -1, -1, 0, 0, 1, 1, 1};
	static int[] Y = { -1, 0, 1, -1, 1, -1, 0, 1};
	static int count = 1;

	public static void main(String[] args) throws IOException {
		// int T = sc.nextInt();
		while (true) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			if (n == 0 || m == 0) break;
			solve(n, m);
			count++;
		}
		System.out.print(sb);
	}

	static void solve(int n, int m) throws IOException {

		char[][] grid = new char[n][m];
		boolean[][] visited = new boolean[n][m];
		Queue<Pair> que = new LinkedList<>();

		for (int i = 0; i < n; i++)
			grid[i] = sc.next().toCharArray();

		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				if (grid[i][j] == 'A') {
					que.add(new Pair(i, j, 1, 0));
					visited[i][j] = true;
				}

		Pair curr = null;

		while (!que.isEmpty()) {

			curr = que.poll();

			for (int i = 0; i < 8; i++) {
				int x = X[i] + curr.x;
				int y = Y[i] + curr.y;

				if (x >= 0 && x < n && y >= 0 && y < m) {

					if (grid[x][y] - 'A' == curr.charValue + 1 && !visited[x][y]) {
						visited[x][y] = true;
						que.add(new Pair(x, y, curr.dist + 1, grid[x][y] - 'A'));
					}

				}

			}
		}

		if (curr == null)
			sb.append("Case " + count + ": 0\n");
		else
			sb.append("Case " + count + ": " + curr.dist + "\n");

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