import java.util.*;
import java.io.*;
import java.math.*;

class SeatingArrangement {

	static class Node {
		long start, end;
		long size;
		Node(long start, long end) {
			this.start = start;
			this.end = end;
			size = end - start + 1;
		}
	}

	static class CustomComparator implements Comparator<Node> {
		public int compare(Node a, Node b) {
			if (a.size > b.size)
				return -1;
			else if (a.size == b.size) {
				if (a.start < b.start)
					return -1;
				else
					return 1;
			} else
				return 1;
		}
	}

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;
	private static int MOD = 1000000007;
	static FastScanner sc = new FastScanner();
	static HashMap<Long, Integer> map = new HashMap<>();
	static StringBuilder sb = new StringBuilder();
	static PriorityQueue<Node> pq = new PriorityQueue<>(new CustomComparator());

	public static void main(String[] args) throws IOException {
		// int T = sc.nextInt();
		// while (T-- > 0) {
		solve();
		// }
	}

	static void solve() throws IOException {

		long n = sc.nextLong();
		int k = sc.nextInt();

		char[] arr = sc.next().toCharArray();

		pq.offer(new Node(1, n));

		for (int i = 0; i < k; i++) {

			Node curr = pq.poll();
			long pos = -1;

			if ((curr.size & 1) == 0) {
				long size1 = curr.start + (curr.size / 2) - 1;
				pos = size1;
				if (arr[i] == 'R')
					pos++;
			} else
				pos = curr.start + (curr.size / 2);

			map.put(pos, i + 1);
			if (curr.start < pos)
				pq.offer(new Node(curr.start, pos - 1));
			if (curr.end > pos)
				pq.offer(new Node(pos + 1, curr.end));

		}

		int queries = sc.nextInt();

		while (queries-- > 0) {
			long pos = sc.nextLong();
			if (!map.containsKey(pos))
				sb.append("-1\n");
			else
				sb.append(map.get(pos) + "\n");
		}

		System.out.print(sb);

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