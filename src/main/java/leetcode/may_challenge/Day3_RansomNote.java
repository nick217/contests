package leetcode.may_challenge;

/*	Link: https://leetcode.com/problems/ransom-note/
 * 	Given an arbitrary ransom note string and another string containing letters 
 * 	from all the magazines, write a function that will return true if the ransom note 
 * 	can be constructed from the magazines ; otherwise, it will return false.
 * 	Each letter in the magazine string can only be used once in your ransom note.

	Note:
	You may assume that both strings contain only lowercase letters.

	canConstruct("a", "b") -> false
	canConstruct("aa", "ab") -> false
	canConstruct("aa", "aab") -> true
 */
public class Day3_RansomNote {
	public boolean canConstruct(String ransomNote, String magazine) {
		char[] m = new char[26];
		for (int i = 0; i < magazine.length(); i++) {
			m[magazine.charAt(i) - 'a']++;
		}
		for (int i = 0; i < ransomNote.length(); i++) {
			int c = ransomNote.charAt(i) - 'a';
			if (m[c] == 0) {
				return false;
			} else {
				m[c]--;
			}
		}
		return true;
	}
}
