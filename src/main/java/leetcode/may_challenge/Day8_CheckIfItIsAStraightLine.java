package leetcode.may_challenge;

/*
 * Link: https://leetcode.com/problems/check-if-it-is-a-straight-line/
 * You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the 
 * coordinate of a point. 
 * Check if these points make a straight line in the XY plane.
 * 
 * Example 1:
 * Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
   Output: true
   
   Example 2:
   Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
   Output: false
   
   Constraints:
	2 <= coordinates.length <= 1000
	coordinates[i].length == 2
	-10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
	coordinates contains no duplicate point.
 */
 /*
  * Concept used:
  * Slope of a line if its 2 points (x1, y1) and (x2, y2) are given is
  *  	m = (y2 - y1) / (x2 - x1)
  */
public class Day8_CheckIfItIsAStraightLine {
	public boolean checkStraightLine(int[][] coordinates) {
		float m = (float) (coordinates[1][1] - coordinates[0][1]) 
						/ (coordinates[1][0] - coordinates[0][0]);
		float currentSlope;
		for (int i = 2; i < coordinates.length; i++) {
			currentSlope = (float) (coordinates[i][1] - coordinates[i - 1][1])
					/ (coordinates[i][0] - coordinates[i - 1][0]);
			if (m != currentSlope) {
				return false;
			}
		}
		return true;
	}
}
