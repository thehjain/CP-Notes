import java.util.*;
import java.io.*;
import java.math.*;

class MaximumSumOnEvenPositions {

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;
	private static int MOD = 1000000007;
	static FastScanner sc = new FastScanner();

	public static void main(String[] args) throws IOException {
		int T = sc.nextInt();
		while (T-- > 0) {
			solve();
		}
	}

	static void solve() throws IOException {

		int n = sc.nextInt();

		long[] arr = new long[n];

		for (int i = 0; i < n; i++)
			arr[i] = sc.nextLong();

		long evenSum = 0;

		for (int i = 0; i < n; i += 2)
			evenSum += arr[i];

		ArrayList<Long> evenStart = new ArrayList<>();
		ArrayList<Long> oddStart = new ArrayList<>();


		for (int i = 1; i < n; i += 2)
			evenStart.add(arr[i] - arr[i - 1]);
		for (int i = 2; i  < n; i += 2)
			oddStart.add(arr[i - 1] - arr[i]);

		// for (long ele : oddStart)
		// 	System.out.print(ele + " ");

		long incrementSum = Math.max(sumSubarray(evenStart), sumSubarray(oddStart));
		incrementSum = Math.max(0, incrementSum);

		System.out.println(evenSum + incrementSum);

	}

	static long sumSubarray(ArrayList<Long> arr) {

		int size = arr.size();

		long max_so_far = Long.MIN_VALUE;
		long max_ending_here = 0;

		for (int i = 0; i < size; i++) {
			max_ending_here += arr.get(i);
			if (max_so_far < max_ending_here)
				max_so_far = max_ending_here;
			if (max_ending_here < 0)
				max_ending_here = 0;
		}
		return max_so_far;
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