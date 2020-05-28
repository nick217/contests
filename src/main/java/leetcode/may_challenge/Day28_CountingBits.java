package leetcode.may_challenge;

/*
 * 	Link: https://leetcode.com/problems/counting-bits/
 * 	Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate 
 * 	the number of 1's in their binary representation and return them as an array.

	Example 1:
	Input: 2
	Output: [0,1,1]
	
	Example 2:
	Input: 5
	Output: [0,1,1,2,1,2]

	Follow up:
	It is very easy to come up with a solution with run time O(n*sizeof(integer)). 
	But can you do it in linear time O(n) /possibly in a single pass?
	Space complexity should be O(n).
	Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
 */
public class Day28_CountingBits {
	public int[] countBits(int num) {
		if (num == 0) {
			return new int[] { 0 };
		}
		if (num == 1) {
			return new int[] { 0, 1 };
		}
		int[] bits = new int[num + 1];
		bits[0] = 0;
		bits[1] = 1;
		int curr_power_of_2 = 1;
		int max_power_of_2 = 2;
		int i = 2;
		while (i <= num) {
			if (i == max_power_of_2) {
				bits[i] = 1;
				curr_power_of_2 = max_power_of_2;
				max_power_of_2 = max_power_of_2 << 1;
			} else {
				bits[i] = 1 + bits[i - curr_power_of_2];
			}
			i++;
		}
		return bits;
	}
}
