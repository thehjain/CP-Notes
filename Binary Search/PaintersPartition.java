
//This is not complete code
//It is the solution of InterviewBit Problem
/////////Painter's Partition Problem/////////////

public class Solution {
    public int paint(int A, int B, int[] C) {
        int n = C.length;
        long end = 0;
        for (int ele : C)
            end += (long)ele;
        long start = 0;
        long res = Long.MAX_VALUE;

        while (start <= end) {
            long mid = start + (end - start) / 2;
            if (isPossible(mid, C, A)) {
                res = Math.min(res, mid);
                end = mid - 1;
            } else
                start = mid + 1;
        }
        // System.out.println(res);
        return (int)(res % 10000003 * (long)B % 10000003) % 10000003;
    }

    boolean isPossible(long mid, int[] arr, int A) {

        for (int ele : arr)
            if ((long)ele > mid)
                return false;

        long sum = 0;
        int count = 1;

        for (int ele : arr) {
            if (sum + (long)ele > mid) {
                count++;
                sum = (long)ele;
            } else {
                sum += (long)ele;
            }
        }

        if (count <= A)
            return true;
        return false;

    }

}