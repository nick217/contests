package leetcode.may_challenge;

/*
 * 	Link: https://leetcode.com/problems/single-element-in-a-sorted-array/
 * 	You are given a sorted array consisting of only integers where every element appears exactly twice, 
 * 	except for one element which appears exactly once. Find this single element that appears only once.

	Example 1:
	Input: [1,1,2,3,3,4,4,8,8]
	Output: 2

	Example 2:
	Input: [3,3,7,7,10,11,11]
	Output: 10
 
 	Note: Your solution should run in O(log n) time and O(1) space.
 */
public class Day12_SingleElementInASortedArray {
	public int singleNonDuplicate(int[] nums) {
		return searchSingleElement(nums, 0, nums.length - 1);
	}

	public int searchSingleElement(int[] nums, int left, int right) {
		if (left == right) {
			return nums[left];
		}
		int mid = (left + right) / 2;
		if (mid % 2 == 0) {
			if (nums[mid] == nums[mid + 1]) {
				return searchSingleElement(nums, mid + 1, right);
			} else {
				return searchSingleElement(nums, left, mid);
			}
		} else {
			if (nums[mid - 1] == nums[mid]) {
				return searchSingleElement(nums, mid + 1, right);
			} else {
				return searchSingleElement(nums, left, mid);
			}
		}
	}
}
