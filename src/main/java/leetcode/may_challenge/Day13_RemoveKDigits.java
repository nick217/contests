package leetcode.may_challenge;

import java.util.Stack;

/*
 * 	Link: https://leetcode.com/problems/remove-k-digits/
 * 	Given a non-negative integer num represented as a string, remove k digits from the number so that 
 * 	the new number is the smallest possible.

	Note:
	The length of num is less than 10002 and will be ≥ k.
	The given num does not contain any leading zero.

	Example 1:
	Input: num = "1432219", k = 3
	Output: "1219"
	Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.

	Example 2:
	Input: num = "10200", k = 1
	Output: "200"
	Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain 
	leading zeroes.

	Example 3:
	Input: num = "10", k = 2
	Output: "0"
	Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 */
public class Day13_RemoveKDigits {
	public String removeKdigits(String num, int k) {
		if (k == 0)
			return num;
		if (k == num.length())
			return "0";

		int top = -1;
		int length = num.length();

		char stack[] = new char[length];

		for (int i = 0; i < length; i++) {
			while (top > -1 && k > 0 && stack[top] > num.charAt(i)) {
				top--;
				k--;
			}
			stack[++top] = num.charAt(i);
		}
		while (k > 0) {
			top--;
			k--;
		}
		int end = 0;
		while (end < top && stack[end] == '0') {
			end++;
		}
		StringBuilder sb = new StringBuilder();
		while (end <= top) {
			sb.append(stack[end++]);
		}
		return sb.toString();
	}

	public String removeKdigitsUsingStack(String num, int k) {
		if (k == 0)
			return num;
		if (k == num.length())
			return "0";

		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < num.length(); i++) {
			while (!stack.isEmpty() && k > 0 && stack.peek() > num.charAt(i)) {
				stack.pop();
				k--;
			}
			stack.push(num.charAt(i));
		}
		while (k > 0) {
			stack.pop();
			k--;
		}
		StringBuilder str = new StringBuilder();
		while (!stack.isEmpty()) {
			str.append(stack.pop());
		}
		str.reverse();
		while (str.length() > 1 && str.charAt(0) == '0') {
			str.deleteCharAt(0);
		}
		return str.toString();
	}
}
