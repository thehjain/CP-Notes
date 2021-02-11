import java.util.*;
import java.io.*;
import java.math.*;

class CodeMonk {

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;
	private static int MOD = 1000000007;
	static FastScanner sc = new FastScanner();
	static StringBuilder sb = new StringBuilder();
	static TreeSet<Integer> set = new TreeSet<>();
	static Map<Integer, Integer> map = new HashMap<>();

	public static void main(String[] args) throws IOException {
		int T = sc.nextInt();
		while (T-- > 0) {
			solve(sc.next());
		}
		System.out.print(sb);
	}

	static void solve(String s) throws IOException {
		if (s.equals("CountHigh")) {
			if (set.size() == 0)
				sb.append("-1\n");
			else
				sb.append(map.get(set.last()) + "\n");
		} else if (s.equals("Push")) {
			int num = sc.nextInt();
			set.add(num);
			if (!map.containsKey(num))
				map.put(num, 0);
			map.put(num, map.get(num) + 1);
		} else if (s.equals("Diff")) {
			if (set.size() == 0)
				sb.append(-1 + "\n");
			else if (set.size() == 1) {
				int num = set.first();
				int freq = map.get(num) - 1;
				map.put(num, freq);
				if (freq == 0) set.remove(num);
				sb.append(0 + "\n");
			} else {
				int low = set.first();
				int high = set.last();
				int lowFreq = map.get(low) - 1;
				int highFreq = map.get(high) - 1;
				if (lowFreq == 0) set.remove(low);
				if (highFreq == 0) set.remove(high);
				map.put(low, lowFreq);
				map.put(high, highFreq);
				sb.append((high - low) + "\n");
			}
		} else if (s.equals("CountLow")) {
			if (set.size() == 0) sb.append("-1\n");
			else sb.append(map.get(set.first()) + "\n");
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