

//Question Link

//https://www.hackerearth.com/practice/algorithms/searching/linear-search/practice-problems/algorithm/simple-search-4/


//Just Simple Search to find an index of an element

import java.util.*;

class TestClass {
	public static void main(String args[] ) throws Exception {
		//  Sample code to perform I/O:
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int res = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int k = sc.nextInt();

		for (int i = 0; i < n; i++)
			if (k == arr[i])
				res = i;

		System.out.println(res);

	}
}


//Problem is available on HackerEarth