
//Here Segmented Sieve is used
//this is little bit different from sieve of erastothenes


//for large value of n sieve of erastothenes not work
//becaue of space so that's where we use segmented sieve

//Watch Coding Ninjas video on segment sieve to understand


import java.util.*;
import java.io.*;
import java.math.*;

class PRIME1 {

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;
	private static int MOD = 1000000007;
	static FastScanner sc = new FastScanner();
	static StringBuilder sb = new StringBuilder();
	static ArrayList<Integer> prime = new ArrayList<>();

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
		int m = sc.nextInt();

		findPrimes(n, m);

		sb.append("\n");

	}

	static void findPrimes(int l, int r) {

		boolean[] isPrime = new boolean[r - l + 1];
		Arrays.fill(isPrime, true);
		// System.out.println(l + " " + r);
		for (int i = 0; prime.get(i) * prime.get(i) <= r; i++) {

			int currPrime = prime.get(i);
			int base = (l / currPrime) * currPrime;

			if (base < l)
				base += currPrime;

			for (int j = base; j <= r; j += currPrime)
				isPrime[j - l] = false;

			if (base == currPrime)
				isPrime[base - l] = true;

		}

		int count = 0;
		if (l == 1)
			isPrime[0] = false;
		for (int i = 0; i <= r - l; i++)
			if (isPrime[i])
				sb.append((i + l) + "\n");

	}

	static void sieve() {

		int n = 100001;
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



//Segmented Sieve