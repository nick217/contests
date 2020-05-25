package leetcode.may_challenge;

import java.util.Arrays;

/*
 * 	Link: https://leetcode.com/problems/contiguous-array/
 * 	Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

	Example 1:
	Input: [0,1]
	Output: 2
	Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.

	Example 2:
	Input: [0,1,0]
	Output: 2
	Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
	Note: The length of the given binary array will not exceed 50,000.
 */
public class Day26_ContiguousArray {
	
	public int findMaxLength(int[] nums) {
		int count = 0;
		int sum[] = new int[2 * nums.length + 1];
		Arrays.fill(sum, -2);
		sum[nums.length] = -1;
		int maxLen = 0;
		for (int i = 0; i < nums.length; i++) {
			count += nums[i] == 1 ? 1 : -1;
			if (sum[count + nums.length] >= -1) {
				maxLen = Math.max(maxLen, i - sum[count + nums.length]);
			} else {
				sum[count + nums.length] = i;
			}
		}
		return maxLen;
	}
}
