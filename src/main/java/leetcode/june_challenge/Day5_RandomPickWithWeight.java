package leetcode.june_challenge;

import java.util.Random;

/*
 * 	Link: https://leetcode.com/problems/random-pick-with-weight/
 * 	Given an array w of positive integers, where w[i] describes the weight of index i, 
 * 	write a function pickIndex which randomly picks an index in proportion to its weight.

	Note:
	1 <= w.length <= 10000
	1 <= w[i] <= 10^5
	pickIndex will be called at most 10000 times.

	Example 1:
	Input: 
	["Solution","pickIndex"]
	[[[1]],[]]
	Output: [null,0]

	Example 2:
	Input: 
	["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
	[[[1,3]],[],[],[],[],[]]
	Output: [null,0,1,1,1,0]
	Explanation of Input Syntax:
	The input is two lists: the subroutines called and their arguments. 
	Solution's constructor has one argument, the array w. pickIndex has no arguments. 
	Arguments are always wrapped with a list, even if there aren't any.
 */
public class Day5_RandomPickWithWeight {
	Random random;
	int[] preSum;

	public Day5_RandomPickWithWeight(int[] w) {
		random = new Random();
		for (int i = 1; i < w.length; i++) {
			w[i] += w[i - 1];
		}
		this.preSum = w;
	}

	public int pickIndex() {
		int length = preSum.length;
		int target = random.nextInt(preSum[length - 1]) + 1;
		int start = 0;
		int end = length - 1;
		// generate increasing array and search based on value
		// find next larger
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (preSum[mid] == target) {
				return mid;
			} else if (preSum[mid] > target) {
				end = mid;
			} else {
				start = mid;
			}
		}
		if (preSum[start] < target) {
			return end;
		} else {
			return start;
		}
	}
}
