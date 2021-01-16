
//Here we have to find the maximum sum
//in an array and the count the number of
//elements contributing in it.

import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {

        int count = 0;
        long sum = 0;

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[] arr = new long[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextLong();

        Arrays.sort(arr);

        sum += arr[n - 1];
        count++;

        for (int i = n - 2; i >= 0; i--)
            if (sum + arr[i] >= sum) {
                count++;
                sum += arr[i];
            }

        System.out.println(sum + " " + count);

    }
}