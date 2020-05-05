package leetcode.may_challenge;

/*
 * 	Link: https://leetcode.com/problems/first-unique-character-in-a-string/
 * 	Given a string, find the first non-repeating character in it and return it's index. 
 * 	If it doesn't exist, return -1.
	Examples:
	s = "leetcode"
	return 0.

	s = "loveleetcode",
	return 2.
	Note: You may assume the string contain only lowercase letters.
 */

public class Day5_FirstUniqueCharacterInAString {
	public int firstUniqChar(String s) {
		char arr[] = new char[26];
		char str[] = s.toCharArray();
		for (char c : str) {
			arr[c - 'a']++;
		}
		for (int i = 0; i < str.length; i++) {
			if (arr[str[i] - 'a'] == 1) {
				return i;
			}
		}
		return -1;
	}
}
