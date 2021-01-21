

//With brute force approach this problem will take O(N^3).
//With sliding Window it will take O(N^2).
//But with stack we can do it in O(N).

import java.util.*;
import java.io.*;
import java.math.*;

class MinMaxRiddle {

    private static int MAX = Integer.MAX_VALUE;
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

        int[] arr = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];
        int[] res = new int[n + 1];

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        Arrays.fill(left, -1);
        Arrays.fill(right, n);

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i])
                st.pop();
            if (!st.isEmpty())
                left[i] = st.peek();
            st.push(i);
        }

        st.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i])
                st.pop();
            if (!st.isEmpty())
                right[i] = st.peek();
            st.push(i);
        }

        for (int i = 0; i < n; i++) {
            int len = right[i] - left[i] - 1;
            res[len] = Math.max(res[len], arr[i]);
        }

        for (int i = n - 1; i >= 0; i--) {
            res[i] = Math.max(res[i], res[i + 1]);
        }

        for (int i = 1; i <= n; i++)
            System.out.print(res[i] + " ");

        System.out.println();

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