package leetcode.may_challenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * 	Link: https://leetcode.com/problems/possible-bipartition/solution/
 * 	Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.
	Each person may dislike some other people, and they should not go into the same group. 
	Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.
	Return true if and only if it is possible to split everyone into two groups in this way.

 	Example 1:
	Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
	Output: true
	Explanation: group1 [1,4], group2 [2,3]
	
	Example 2:
	Input: N = 3, dislikes = [[1,2],[1,3],[2,3]]
	Output: false

	Example 3:
	Input: N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
	Output: false
 
	Note:
	1 <= N <= 2000
	0 <= dislikes.length <= 10000
	1 <= dislikes[i][j] <= N
	dislikes[i][0] < dislikes[i][1]
	There does not exist i != j for which dislikes[i] == dislikes[j].
 */
public class Day27_PossibleBipartition {
	ArrayList<Integer>[] graph;
	Map<Integer, Integer> color;

	//Takes O(N+E) time.
	public boolean possibleBipartitionUsingDFS(int N, int[][] dislikes) {
		graph = new ArrayList[N + 1];
		color = new HashMap<>();
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int[] d : dislikes) {
			graph[d[0]].add(d[1]);
			graph[d[1]].add(d[0]);
		}

		for (int i = 1; i <= N; i++) {
			if (!color.containsKey(i) && !(dfs(i, 0)))
				return false;
		}
		return true;
	}

	public boolean dfs(int node, int c) {
		if (color.containsKey(node)) {
			return color.get(node) == c;
		}
		color.put(node, c);
		for (int n : graph[node]) {
			if (!dfs(n, c ^ 1)) {
				return false;
			}
		}
		return true;
	}
	//Uses primitive types and takes O(N) time.
	public boolean possibleBipartition(int N, int[][] dislikes) {
        int[] ids = new int[N+1];
        for(int i=0; i < ids.length; i++) {
            ids[i] = i;
        }
        
        for(int[] x: dislikes) {
            int one = x[0];
            int two = x[1];
            
            if (ids[one] == one && ids[two] == two) {
                ids[one] = two;
                ids[two] = one;
            }
            else if (ids[one] != one && ids[two] == two) {
                ids[two] = ids[ids[one]];
            }
            else if (ids[one] == one && ids[two] != two) {
                ids[one] = ids[ids[two]];
            }
            else if (ids[one] == ids[two]) {
                return false;
            }            
        }
        return true;
    }
}
