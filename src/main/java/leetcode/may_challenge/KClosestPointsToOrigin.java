package leetcode.may_challenge;

import java.util.Arrays;

/*
 * 	Link: https://leetcode.com/problems/k-closest-points-to-origin/
 * 	We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
 * 	(Here, the distance between two points on a plane is the Euclidean distance.)
 * 	You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)

 	Example 1:
	Input: points = [[1,3],[-2,2]], K = 1
	Output: [[-2,2]]
	Explanation: 
	The distance between (1, 3) and the origin is sqrt(10).
	The distance between (-2, 2) and the origin is sqrt(8).
	Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
	We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].

	Example 2:
	Input: points = [[3,3],[5,-1],[-2,4]], K = 2
	Output: [[3,3],[-2,4]]
	(The answer [[-2,4],[3,3]] would also be accepted.)
 	
 	Note:
	1 <= K <= points.length <= 10000
	-10000 < points[i][0] < 10000
	-10000 < points[i][1] < 10000
 */
public class KClosestPointsToOrigin {
	class Coordinate {
		int x;
		int y;
		int distance_from_origin;

		Coordinate(int xc, int yc) {
			x = xc;
			y = yc;
			distance_from_origin = (y * y) + (x * x);
		}

		public String toString() {
			return x + " " + y + " " + distance_from_origin;
		}
	}

	public int[][] kClosest(int[][] points, int K) {
		if (K >= points.length) {
			return points;
		}
		Coordinate coordinates[] = new Coordinate[points.length];
		int j = 0;
		for (int[] p : points) {
			coordinates[j++] = new Coordinate(p[0], p[1]);
		}
		Arrays.sort(coordinates, ((Coordinate c1, Coordinate c2) -> c1.distance_from_origin - c2.distance_from_origin));

		int result[][] = new int[K][2];
		for (int i = 0; i < K; i++) {
			result[i][0] = coordinates[i].x;
			result[i][1] = coordinates[i].y;
		}
		return result;
	}
}
