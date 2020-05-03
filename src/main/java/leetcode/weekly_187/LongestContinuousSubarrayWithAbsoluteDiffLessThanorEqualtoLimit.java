package leetcode.weekly_187;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/*
 * 	Link: https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
 * 	Given an array of integers nums and an integer limit, return the size of the longest 
 * 	continuous subarray such that the absolute difference between any two elements is less than 
 * 	or equal to limit.
 *  In case there is no subarray satisfying the given condition return 0.

	Example 1:
	Input: nums = [8,2,4,7], limit = 4
	Output: 2 

	Example 2:
	Input: nums = [10,1,2,4,7,2], limit = 5
	Output: 4 
	Explanation: The subarray [2,4,7,2] is the longest since the maximum absolute diff is |2-7| = 5 <= 5.

	Example 3:
	Input: nums = [4,2,2,2,4,4,2,2], limit = 0
	Output: 3
 
	Constraints:
	1 <= nums.length <= 10^5
	1 <= nums[i] <= 10^9
	0 <= limit <= 10^9
 */
public class LongestContinuousSubarrayWithAbsoluteDiffLessThanorEqualtoLimit {
	// O(n)
	public int longestSubarray(int[] nums, int limit) {

		Deque<Integer> maxD = new ArrayDeque<>();
		Deque<Integer> minD = new ArrayDeque<>();
		int k = 0;
		int max = 0;
		for (int i = 0; i < nums.length; i++) {

			while (!maxD.isEmpty() && nums[i] > maxD.peekLast()) {
				maxD.pollLast();
			}
			while (!minD.isEmpty() && nums[i] < minD.peekLast()) {
				minD.pollLast();
			}
			maxD.offerLast(nums[i]);
			minD.offerLast(nums[i]);

			while (maxD.peek() - minD.peek() > limit) {
				if (nums[k] == maxD.peek()) {
					maxD.pollFirst();
				}
				if (nums[k] == minD.peek()) {
					minD.pollFirst();
				}
				k++;
			}
			max = Math.max(max, i - k);
		}
		return max + 1;
	}

	// O(n^2) //Resulted in TLE
	public int longestSubarrayDP(int[] nums, int limit) {
		Map<String, Integer> hm = new HashMap<>();
		int max = 1;
		for (int i = 1; i < nums.length; i++) {
			if (Math.abs(nums[i] - nums[i - 1]) <= limit) {
				hm.put(i - 1 + "" + i, 2);
				max = 2;
			} else {
				hm.put(i - 1 + "" + i, 0);
			}
		}
		for (int i = 2; i < nums.length; i++) {
			int k = i;
			for (int j = i; j < nums.length; j++) {
				int val1 = hm.get(j - k + "" + (j - 1));
				int val2 = hm.get(j - k + 1 + "" + (j));
				if (val1 != 0 && val2 != 0 && Math.abs(nums[j] - nums[j - k]) <= limit) {
					hm.put(j - k + "" + j, val1 + 1);
					max = val1 + 1;
				} else {
					hm.put(j - k + "" + j, 0);
				}
			}
		}
		return max;
	}
}
