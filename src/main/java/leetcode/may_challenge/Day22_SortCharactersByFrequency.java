package leetcode.may_challenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
 * 	Link: https://leetcode.com/problems/sort-characters-by-frequency/
 * 	Given a string, sort it in decreasing order based on the frequency of characters.
	Example 1:
	Input:
		"tree"
	Output:
		"eert"
	Explanation:
		'e' appears twice while 'r' and 't' both appear once.
		So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.

	Example 2:
	Input:
		"cccaaa"
	Output:
		"cccaaa"
	Explanation:
		Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
		Note that "cacaca" is incorrect, as the same characters must be together.
	
	Example 3:
	Input:
		"Aabb"
	Output:
		"bbAa"
	Explanation:
	"bbaA" is also a valid answer, but "Aabb" is incorrect.
	Note that 'A' and 'a' are treated as two different characters.
 */
public class Day22_SortCharactersByFrequency {

	public String frequencySort(String s) {

		Map<Character, Integer> characterCount = new HashMap<>();
		int length = s.length();
		for (int i = 0; i < length; i++) {
			characterCount.put(s.charAt(i), characterCount.getOrDefault(s.charAt(i), 0) + 1);
		}
		Map<Integer, List<Character>> distinctCounts = new TreeMap<>(Collections.reverseOrder());

		for (Character c : characterCount.keySet()) {
			int count = characterCount.get(c);
			List<Character> chars;
			chars = distinctCounts.getOrDefault(count, new ArrayList<>());
			chars.add(c);
			distinctCounts.put(count, chars);
		}
		StringBuilder sb = new StringBuilder();

		for (Integer count : distinctCounts.keySet()) {
			List<Character> chars = distinctCounts.get(count);
			for (Character c : chars) {
				for (int i = 0; i < count; i++) {
					sb.append(c);
				}
			}
		}
		return sb.toString();
	}

	// Takes less time compared to above version, use of HashMap and TreeMap has been avoided.
	// Only Arrays and ArrayList is used.
	public String frequencySortUsingPrimitives(String s) {
		if (s == null || s.isEmpty())
			return s;
		int[] count = new int[256];
		for (char ch : s.toCharArray())
			count[ch]++;
		List<Character>[] buckets = new ArrayList[s.length() + 1];
		for (int i = 0; i < count.length; i++) {
			if (count[i] != 0) {
				if (buckets[count[i]] == null)
					buckets[count[i]] = new ArrayList<>();
				buckets[count[i]].add((char) i);
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = buckets.length - 1; i >= 0; i--) {
			if (buckets[i] != null) {
				for (int j = 0; j < buckets[i].size(); j++) {
					char temp = buckets[i].get(j);
					for (int k = 0; k < i; k++) {
						sb.append(temp);
					}
				}
			}
		}
		return sb.toString();
	}
}
