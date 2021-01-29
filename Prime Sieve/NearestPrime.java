
//Using Binary Search and Prime Sieve

import java.util.*;
import java.io.*;
import java.math.*;

class NearestPrime {

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;
	private static int MOD = 1000000007;
	static FastScanner sc = new FastScanner();
	static ArrayList<Integer> arr = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int T = sc.nextInt();
		sieve();
		while (T-- > 0) {
			solve();
		}
		System.out.print(sb);
	}

	static void solve() throws IOException {

		int n = sc.nextInt();

		int lower = lower_bound(n);
		int high = higher_bound(n);

		if (Math.abs(lower - n) <= Math.abs(high - n))
			sb.append(lower + "\n");
		else
			sb.append(high + "\n");

	}

	static int lower_bound(int n) {

		int low = 0;
		int high = arr.size() - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr.get(mid) == n) {
				return arr.get(mid);
			}
			if (arr.get(mid) < n)
				low = mid + 1;
			else
				high = mid - 1;
		}
		return arr.get(high);
	}

	static int higher_bound(int n) {

		int low = 0;
		int high = arr.size() - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr.get(mid) == n)
				return arr.get(mid);
			if (arr.get(mid) < n)
				low = mid + 1;
			else
				high = mid - 1;
		}
		return arr.get(low);
	}

	static void sieve() {

		int n = 1000001;
		boolean[] isPrime = new boolean[n];
		Arrays.fill(isPrime, true);

		for (int p = 2; p * p < n; p++) {
			if (isPrime[p]) {
				for (int i = p * p; i < n; i += p)
					isPrime[i] = false;
			}
		}

		for (int i = 2; i < n; i++)
			if (isPrime[i])
				arr.add(i);

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



//Available on HackerEarth