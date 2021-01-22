import java.util.*;
import java.io.*;
import java.math.*;

// class Pair {
// 	int countOne;
// 	int countZero;
// 	Pair(int countOne, int countZero) {
// 		this.countZero = countZero;
// 		this.countOne = countOne;
// 	}
// }

class BDGFT {

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
		System.out.println(sb);
	}

	static void solve() throws IOException {

		char[] arr = sc.next().toCharArray();

		int n = arr.length;

		int res = 0;

		// Pair[] count = new Pair[n];
		int[] prefix = new int[n + 1];

		// int countOne = 0, countZero = 0;
		int countOne = 0;
		// for (int i = 0; i < n; i++) {
		// 	if (arr[i] == '0') countZero++;
		// 	else countOne++;
		// 	count[i] = new Pair(countOne, countZero);
		// }

		for (int i = 0; i < n; i++) {
			if (arr[i] == '1') countOne++;
			prefix[i + 1] = countOne;
		}

		// for (int i = 0; i < n - 1; i++) {
		// 	for (int j = i + 1; j < n; j++) {
		// 		if (i == 0) {
		// 			countZero = count[j].countZero;
		// 			countOne = count[j].countOne;
		// 		} else {
		// 			countZero = count[j].countZero - count[i - 1].countZero;
		// 			countOne = count[j].countOne - count[i - 1].countOne;
		// 		}
		// 		if (countZero == countOne * countOne)
		// 			res++;
		// 	}
		// }

		for (int i = 0; i < n; i++) {
			for (int j = 1; j * j + j + i <= n; j++) {
				if (prefix[j * j + j + i] - prefix[i] == j)
					res++;
			}
		}


		sb.append(res + "\n");

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