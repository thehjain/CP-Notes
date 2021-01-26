import java.util.*;
import java.io.*;
import java.math.*;

public class SagheerAndNubianMarket {

	static class Pair {
		long value;
		int index;
		Pair(long value, int index) {
			this.value = value;
			this.index = index;
		}
	}

	static class MyComparator implements Comparator<Pair> {
		public int compare(Pair a, Pair b) {
			return (int)(a.value - b.value);
		}
	}

	private static long MAX = Long.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;
	private static int MOD = 1000000007;
	static FastScanner sc = new FastScanner();

	public static void main(String[] args) throws IOException {
		// int T = sc.nextInt();
		// while (T-- > 0) {
		solve();
		// }
	}

	static void solve() throws IOException {

		int n = sc.nextInt();
		long S = sc.nextLong();

		Pair[] arr = new Pair[n];
		for (int i = 0; i < n; i++) {
			arr[i] = new Pair(sc.nextLong(), i + 1);
		}

		Arrays.sort(arr, new MyComparator());

		long start = 1, end = n;
		long sum = 0;
		long ans = 0;

		while (start <= end) {

			long mid = start + (end - start) / 2;
			long temp = isValid(arr, mid, S);
			if (temp != -1) {
				sum = temp;
				ans = mid;
				start = mid + 1;
			} else
				end = mid - 1;
		}
		System.out.println(ans + " " + sum);
	}

	static long isValid(Pair[] arr, long k, long budget) {
		long sum = 0;
		long [] temp = new long[arr.length];
		for (int i = 0; i < arr.length; i++)
			temp[i] = arr[i].value + arr[i].index * k;
		Arrays.sort(temp);
		for (int i = 0; i < k; i++) {
			sum += temp[i];
			if (sum > budget) break;
		}
		if (sum <= budget) return sum;
		return -1;
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