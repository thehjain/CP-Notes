import java.util.*;
import java.io.*;
import java.math.*;

class PrimeCounting {

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;
	private static int MOD = 1000000007;
	static FastScanner sc = new FastScanner();
	static int num = 100001;
	static ArrayList<Integer> prime = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		int T = sc.nextInt();
		sieve();
		while (T-- > 0) {
			solve();
		}
	}

	static void solve() throws IOException {

		int n = sc.nextInt();

		int low = MIN;
		int high = MAX;

		boolean flag = true;

		for (int i = 0; i < n; i++) {
			int l = sc.nextInt();
			int r = sc.nextInt();

			if (l > high) {
				flag = false;
			}

			low = Math.max(low, l);
			high = Math.min(r, high);

		}

		// System.out.println(low + " " + high);

		if (!flag) {
			System.out.println(-1);
			return;
		}

		int res = countPrimes(low, high);

		System.out.println(res);
	}

	static int countPrimes(int low, int high) {

		int count = 0;
		boolean[] isPrime = new boolean[high - low + 1];
		Arrays.fill(isPrime, true);
		for (int ele : prime) {

			int base = (low / ele) * ele;

			if (base < low)
				base += ele;

			if (ele > high)
				break;

			for (int i = base; i <= high; i += ele)
				isPrime[i - low] = false;
			// System.out.print(base + " ");
			if (base == ele)
				isPrime[base - low] = true;

		}

		for (boolean ele : isPrime)
			if (ele)
				count++;
		if (low == 1) count--;
		return count;

	}

	static void sieve() {

		boolean[] isPrime = new boolean[num + 1];
		Arrays.fill(isPrime, true);

		for (int p = 2; p * p < num; p++) {
			if (isPrime[p]) {
				for (int i = p * p; i < num; i += p)
					isPrime[i] = false;
			}
		}

		for (int i = 2; i < num; i++)
			if (isPrime[i])
				prime.add(i);

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