package leetcode.biweekly_25;

import java.util.ArrayList;
import java.util.List;

/* Link: https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
 * Given the array candies and the integer extraCandies, where candies[i] represents 
 * the number of candies that the ith kid has.
 * For each kid check if there is a way to distribute extraCandies among the kids such that 
 * he or she can have the greatest number of candies among them. 
 * Notice that multiple kids can have the greatest number of candies.
 */
public class KidsWiththeGreatestNumberofCandies {
	public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

		int max = candies[0];
		for (int i = 1; i < candies.length; i++) {
			max = Math.max(max, candies[i]);
		}
		List<Boolean> kid = new ArrayList<>();
		for (int i = 0; i < candies.length; i++) {
			if (candies[i] + extraCandies >= max) {
				kid.add(true);
			} else {
				kid.add(false);
			}
		}
		return kid;
	}
}
