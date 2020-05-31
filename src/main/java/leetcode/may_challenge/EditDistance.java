package leetcode.may_challenge;

/*
 * 	Link: https://leetcode.com/problems/edit-distance/
 * 	Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
 * 	You have the following 3 operations permitted on a word:
	Insert a character
	Delete a character
	Replace a character

	Example 1:
	Input: word1 = "horse", word2 = "ros"
	Output: 3
	Explanation: 
	horse -> rorse (replace 'h' with 'r')
	rorse -> rose (remove 'r')
	rose -> ros (remove 'e')

	Example 2:
	Input: word1 = "intention", word2 = "execution"
	Output: 5
	Explanation: 
	intention -> inention (remove 't')
	inention -> enention (replace 'i' with 'e')
	enention -> exention (replace 'n' with 'x')
	exention -> exection (replace 'n' with 'c')
	exection -> execution (insert 'u')
 */
public class EditDistance {
	public int minDistance(String word1, String word2) {
		int word1_length = word1.length();
		int word2_length = word2.length();
		int dp[][] = new int[word1_length + 1][word2_length + 1];

		for (int col = 0; col < dp[0].length; col++) {
			dp[0][col] = col;
		}

		for (int row = 0; row < dp.length; row++) {
			dp[row][0] = row;
		}
		for (int row = 1; row < dp.length; row++) {
			for (int col = 1; col < dp[0].length; col++) {
				if (word1.charAt(row - 1) == word2.charAt(col - 1)) {
					dp[row][col] = dp[row - 1][col - 1];
				} else {
					dp[row][col] = 1 + Math.min(dp[row - 1][col - 1], Math.min(dp[row - 1][col], dp[row][col - 1]));
				}
			}
		}
		return dp[word1_length][word2_length];
	}
}
