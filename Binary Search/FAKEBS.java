import java.util.*;
import java.io.*;
import java.math.*;

class FAKEBS {

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;
	private static int MOD = 1000000007;
	static FastScanner sc = new FastScanner();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int T = sc.nextInt();
		while (T-- > 0) {
			solve();
			System.out.print(sb);
		}
	}

	static void solve() throws IOException {

		int n = sc.nextInt();
		int q = sc.nextInt();

		int[] arr = new int[n];
		int[] brr = new int[n];

		HashMap<Integer, Integer> map1 = new HashMap<>();
		HashMap<Integer, Integer> map2 = new HashMap<>();

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			brr[i] = arr[i];
			map1.put(arr[i], i);
		}

		Arrays.sort(brr);

		for (int i = 0; i < n; i++)
			map2.put(brr[i], i);

		int x, pos, less, more, left, right, swaps1, swaps2;

		while (q-- > 0) {

			x = sc.nextInt();
			pos = map1.get(x);
			less = map2.get(x);
			more = n - less - 1;
			left = 0;
			right = n - 1;
			swaps1 = 0;
			swaps2 = 0;

			while (left <= right) {

				int mid = left + (right - left) / 2;
				if (arr[mid] == x) break;
				else if (arr[mid] < x) {
					if (pos > mid) {
						left = mid + 1;
						less--;
					} else {
						swaps1++;
						more--;
						right = mid - 1;
					}
				} else {
					if (pos < mid) {
						more--;
						right = mid - 1;
					} else {
						swaps2++;
						less--;
						left = mid + 1;
					}
				}
				if (less < 0 || more < 0) {
					swaps1 = -1;
					swaps2 = -1;
					break;
				}
			}
			sb.append(Math.max(swaps2, swaps1) + "\n");
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