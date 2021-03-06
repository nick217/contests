package leetcode.may_challenge;

/*
 * 	Link: https://leetcode.com/problems/valid-perfect-square/
 * 	Given a positive integer num, write a function which 
 * 	returns True if num is a perfect square else False.
 * 	Note: Do not use any built-in library function such as sqrt.

	Example 1:
	Input: 16
	Output: true

	Example 2:
	Input: 14
	Output: false
 */
public class Day9_ValidPerfectSquare {

	public boolean isPerfectSquare(int num) {
		long mid;
		long begin = 1;
		long end = num;
		while (begin <= end) {
			mid = begin + (end - begin) / 2;
			if (mid * mid == num) {
				return true;
			}
			if (mid * mid < num) {
				begin = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return false;
	}

	public boolean isPerfectSquareLogarthmicWithoutUsingLong(int num) {
		int mid;
		int begin = 1;
		int end = num;
		while (begin <= end) {
			mid = begin + (end - begin) / 2;
			int res = num / mid;
			int remain = num % mid;
			if (res == mid && remain == 0) {
				return true;
			}
			if (res > mid) {
				begin = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return false;
	}

	public boolean isPerfectSquareLinear(int num) {
		if (num < 2)
			return true;
		long i = 1;
		while (i * i < num) {
			i += 1;
			if (i * i == num)
				return true;
		}
		return false;
	}
}
