import java.util.*;
import java.io.*;
import java.math.*;

class SWAPPALI {

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;
	private static int MOD = 1000000007;
	static FastScanner sc = new FastScanner();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int T = sc.nextInt();
		while (T-- > 0) {
			solve();
		}
		System.out.print(sb);
	}

	static void solve() throws IOException {

		int n = sc.nextInt();

		char[] arr = sc.next().toCharArray();

		int count = 0;
		boolean start = true, end = true;

		int low = 0, high = n - 1;

		while (low < high) {

			if (arr[low] == arr[high]) {
				start = true;
				end = true;
				// continue;
			} else if (low + 1 == high) {
				sb.append("NO\n");
				return;
			} else if (start && arr[low + 1] == arr[high]) {
				swap(arr, low + 1, low);
				start = false;
				end = true;
				count++;
			} else if (end && arr[high - 1] == arr[low]) {
				swap(arr, high, high - 1);
				end = false;
				start = true;
				count++;
			} else {
				sb.append("NO\n");
				return;
			}
			low++;
			high--;
		}
		sb.append("YES\n" + count + "\n");
	}

	static void swap(char[] arr, int a, int b) {
		char temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
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