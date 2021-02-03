

//Problem is present on leetcode named as Reverse Pairs

import java.util.*;

class ReversePairs {
	public static void main(String[] args) {

		int[] nums = new int[] {2, 4, 3, 5, 1};

		System.out.print(reversePairs(nums));

	}
	static int reversePairs(int[] nums) {
		return mergeSort(nums, 0, nums.length - 1);
	}

	static int mergeSort(int[] nums, int low, int high) {

		if (high <= low)
			return 0;

		int mid = low + (high - low) / 2;

		int res = mergeSort(nums, low, mid);
		res += mergeSort(nums, mid + 1, high);
		res += merge(nums, low, mid, high);

		return res;
	}

	static int merge(int[] nums, int low, int mid, int high) {

		int count = 0;

		int j = mid + 1;

		for (int i = low; i <= mid; i++) {
			while (j <= high && nums[i] > 2 * (long)nums[j])
				j++;
			count += (j - (mid + 1));
		}

		Arrays.sort(nums, low, high + 1);

		return count;

	}
}

