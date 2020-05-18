package leetcode.may_challenge;

/*
 * 	Link: https://leetcode.com/problems/permutation-in-string/
 * 	Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. 
 * 	In other words, one of the first string's permutations is the substring of the second string.

	Example 1:
	Input: s1 = "ab" s2 = "eidbaooo"
	Output: True
	Explanation: s2 contains one permutation of s1 ("ba").

	Example 2:
	Input:s1= "ab" s2 = "eidboaoo"
	Output: False
 
	Note:
	The input strings only contain lower case letters.
	The length of both given strings is in range [1, 10,000].
 */

public class Day18_PermutationInString {
	public boolean checkInclusion(String p, String s) {
		int sLength = s.length();
		int pLength = p.length();

		if (sLength < pLength) {
			return false;
		}

		int pAlphabets[] = new int[26];
		int pos;
		int pSum = 0;

		int sAplhabets[] = new int[26];
		int sPartialSum = 0;

		for (int i = 0; i < pLength; i++) {
			pos = p.charAt(i) - 'a';
			pAlphabets[pos]++;
			pSum += pos;

			pos = s.charAt(i) - 'a';
			sAplhabets[pos]++;
			sPartialSum += pos;
		}

		int start = 0;
		int end = pLength;

		if (pSum == sPartialSum) {
			if (isAnagram(sAplhabets, pAlphabets))
				return true;
		}
		while (end < sLength) {
			pos = s.charAt(start) - 'a';
			sAplhabets[pos]--;
			sPartialSum -= pos;
			start++;

			pos = s.charAt(end) - 'a';
			sAplhabets[pos]++;
			sPartialSum += pos;

			if (pSum == sPartialSum) {
				if (isAnagram(sAplhabets, pAlphabets)) {
					return true;
				}
			}

			end++;
		}
		return false;
	}

	public boolean isAnagram(int s[], int p[]) {

		for (int i = 0; i < 26; i++) {
			if (s[i] != p[i])
				return false;
		}
		return true;
	}
}
