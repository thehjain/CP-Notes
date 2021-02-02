import java.util.*;
import java.io.*;
import java.math.*;

class ProductOfThree {

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

		HashSet<Integer> set = new HashSet<>();

		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0 && !set.contains(i)) {
				set.add(i);
				n /= i;
				break;
			}
		}

		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0 && !set.contains(i)) {
				set.add(i);
				n /= i;
				break;
			}
		}

		if (set.size() < 2 || set.contains(n) || n == 1) {
			sb.append("NO\n");
			return;
		} else {
			sb.append("YES\n");
			set.add(n);
			for (int ele : set)
				sb.append(ele + " ");
			sb.append("\n");
		}

		// ArrayList<Integer> arr = new ArrayList<>();

		// for (int i = 2; i <= n / 2; i++)
		// 	if (n % i == 0)
		// 		arr.add(i);

		// int a = 0, b = 0, c = 0;

		// int size = arr.size();

		// boolean flag = false;

		// outer: for (int i = 0; i < size - 2; i++) {
		// 	a = arr.get(i);
		// 	b = arr.get(i + 1);
		// 	c = arr.get(i + 2);
		// 	if (a * b * c > n)
		// 		break;
		// 	for (int j = i + 1; j < size - 1; j++) {
		// 		b = arr.get(j);
		// 		c = arr.get(j + 1);
		// 		if (a * b * c > n)
		// 			break;
		// 		for (int k = j + 1; k < size; k++) {
		// 			c = arr.get(k);
		// 			if (a * b * c == n) {
		// 				flag = true;
		// 				break outer;
		// 			} else if (a * b * c > n)
		// 				break;
		// 		}

		// 	}

		// }

		// if (!flag)
		// 	sb.append("NO\n");
		// else {
		// 	sb.append("YES\n");
		// 	sb.append(a + " " + b + " " + c + "\n");
		// }

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