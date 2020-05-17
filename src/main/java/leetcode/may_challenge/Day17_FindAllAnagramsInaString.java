package leetcode.may_challenge;

import java.util.ArrayList;
import java.util.List;

/*
 * 	Link: https://leetcode.com/problems/find-all-anagrams-in-a-string/
 * 	Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * 	Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 * 	The order of output does not matter.

	Example 1:
	Input:
	s: "cbaebabacd" p: "abc"
	Output:
	[0, 6]
	Explanation:
	The substring with start index = 0 is "cba", which is an anagram of "abc".
	The substring with start index = 6 is "bac", which is an anagram of "abc".

	Example 2:
	Input:
	s: "abab" p: "ab"
	Output:
	[0, 1, 2]

	Explanation:
	The substring with start index = 0 is "ab", which is an anagram of "ab".
	The substring with start index = 1 is "ba", which is an anagram of "ab".
	The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
public class Day17_FindAllAnagramsInaString {
	public List<Integer> findAnagrams(String s, String p) {
		int sLength = s.length();
		int pLength = p.length();

		List<Integer> anagramsStart = new ArrayList<>();

		if (sLength < pLength) {
			return anagramsStart;
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
				anagramsStart.add(start);
		}
		while (end < sLength) {
			pos = s.charAt(start) - 'a';
			sAplhabets[pos]--;
			sPartialSum -= pos;
			start++;

			pos = s.charAt(end) - 'a';
			sAplhabets[pos]++;
			sPartialSum += pos;
			end++;

			if (pSum == sPartialSum) {
				if (isAnagram(sAplhabets, pAlphabets)) {
					anagramsStart.add(start);
				}
			}

		}
		return anagramsStart;
	}

	public boolean isAnagram(int s[], int p[]) {

		for (int i = 0; i < 26; i++) {
			if (s[i] != p[i])
				return false;
		}
		return true;
	}
}
