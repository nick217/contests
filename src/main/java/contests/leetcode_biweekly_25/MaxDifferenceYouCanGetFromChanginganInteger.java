package contests.leetcode_biweekly_25;

/*
 * You are given an integer num. You will apply the following steps exactly two times:
 * Pick a digit x (0 <= x <= 9).
 * Pick another digit y (0 <= y <= 9). The digit y can be equal to x.
 * Replace all the occurrences of x in the decimal representation of num by y.
 * The new integer cannot have any leading zeros, also the new integer cannot be 0.
 * Let a and b be the results of applying the operations to num the first and second times, respectively.
 * Return the max difference between a and b
 * 
 *  Example 1:

	Input: num = 555
	Output: 888
	Explanation: The first time pick x = 5 and y = 9 and store the new integer in a.
	The second time pick x = 5 and y = 1 and store the new integer in b.
	We have now a = 999 and b = 111 and max difference = 888

	Example 2:

	Input: num = 9
	Output: 8
	Explanation: The first time pick x = 9 and y = 9 and store the new integer in a.
	The second time pick x = 9 and y = 1 and store the new integer in b.
	We have now a = 9 and b = 1 and max difference = 8

	Example 3:

	Input: num = 123456
	Output: 820000

	Example 4:

	Input: num = 10000
	Output: 80000

	Example 5:
	
	Input: num = 9288
	Output: 8700
 

	Constraints:

	1 <= num <= 10^8
 */
public class MaxDifferenceYouCanGetFromChanginganInteger {
	public int maxDiff(int num) {
		int[] arr = new int[10];
		int start = 0;
		int k = 10;
		while (num > 0) {
			k--;
			arr[k] = num % 10;
			num /= 10;
		}
		start = k;
		if (start == 9) {
			return 8;
		}
		int arrNew[] = new int[10];
		int a = 0;
		for (int i = start; i < 10; i++) {
			if (arr[i] < 9) {
				arrNew = setEle(arr, arrNew, i, arr[i], 9);
				a = convertArrayToNum(arrNew);
				break;
			} else {
				arrNew[i] = arr[i];
			}
		}

		int arrNewB[] = new int[10];
		int b = 0;
		if (arr[start] != 1) {
			arrNewB = setEle(arr, arrNewB, start, arr[start], 1);
		} else {

			for (int i = start; i < 10; i++) {
				if (arr[i] > 1) {
					arrNewB = setEle(arr, arrNewB, i, arr[i], 0);
					break;
				} else {
					arrNewB[i] = arr[i];
				}
			}
		}
		b = convertArrayToNum(arrNewB);
		return a - b;
	}

	public int convertArrayToNum(int[] arr) {
		int num = 0;
		for (int i = 0; i < arr.length; i++) {
			num *= 10;
			num += arr[i];
		}
		return num;
	}

	public int[] setEle(int arr[], int arrNew[], int start, int ele, int setTo) {
		for (int i = start; i < arr.length; i++) {
			if (arr[i] == ele) {
				arrNew[i] = setTo;
			} else {
				arrNew[i] = arr[i];
			}
		}
		return arrNew;
	}
}
