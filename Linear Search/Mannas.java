

import java.util.*;

class Mannas {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int n = sc.nextInt();

		while (n-- > 0) {
			solve();
		}

	}

	static void solve() {

		char[] arr = sc.next().toCharArray();
		int n = arr.length;
		char[] a = new char[] {'U', 'V', 'O', 'J', 'I', 'T'};

		int count1 = 0, count2 = 0;

		for (int i = 0; i < n; i++) {
			int index = 0;
			if (arr[i] == 'S') {
				for (int j = i + 1; j < n; j++) {
					if (index < 6 && arr[j] == a[index++]) {
						if (index == 2) {
							count1++;
						} else if (index == 5) {
							count2++;
							count1--;
						}
					} else {
						break;
					}
				}
			}
		}
		System.out.println("SUVO = " + count1 + ", SUVOJIT = " + count2);

	}

}