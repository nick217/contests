package leetcode.weekly_187;

/*
 * 	Link: https://leetcode.com/problems/check-if-all-1s-are-at-least-length-k-places-away/
 * 	Given an array nums of 0s and 1s and an integer k, return True if all 1's are at 
 * 	least k places away from each other, otherwise return False.
	
	Example 1:
	Input: nums = [1,0,0,0,1,0,0,1], k = 2
	Output: true
	Explanation: Each of the 1s are at least 2 places away from each other.

	Example 2:
	Input: nums = [1,0,0,1,0,1], k = 2
	Output: false
	Explanation: The second 1 and third 1 are only one apart from each other.

	Example 3:
	Input: nums = [1,1,1,1,1], k = 0
	Output: true

	Example 4:
	Input: nums = [0,1,0,1], k = 1
	Output: true
 	
 	Constraints:
	1 <= nums.length <= 10^5
	0 <= k <= nums.length
	nums[i] is 0 or 1
 */
public class CheckIfAll1sAreAtLeastLengthKPlacesAway {
	public boolean kLengthApart(int[] nums, int k) {

		int i = 0;
		if (k == 0) {
			return true;
		}
		while (i < nums.length && nums[i] == 0) {
			i++;
		}
		if (i == (nums.length - 1)) {
			return true;
		}
		int lastOne = i;
		i++;
		int diff;
		while (i < nums.length) {
			if (nums[i] == 1) {
				diff = i - lastOne - 1;
				if (diff < k) {
					return false;
				}
				lastOne = i;
			}
			i++;
		}
		return true;
	}
}
