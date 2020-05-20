package leetcode.may_challenge;

/*
 * 	Link: https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * 	Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

 	Example 1:
	Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
	Output: 1

	Example 2:
	
	Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
	Output: 3
	
	Follow up:
	What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? 
	How would you optimize the kthSmallest routine?

 	Constraints:
	The number of elements of the BST is between 1 to 10^4.
	You may assume k is always valid, 1 <= k <= BST's total elements.
 */
public class Day20_KthSmallestElementInaBST {
	int nodes_visited = 0;
	boolean node_found = false;
	int kth_node_value = -1;

	public int kthSmallest(TreeNode root, int k) {
		findKthElemenet(root, k);
		return kth_node_value;
	}

	public void findKthElemenet(TreeNode root, int k) {
		if (root != null && !node_found) {
			findKthElemenet(root.left, k);
			nodes_visited++;
			if (nodes_visited == k) {
				node_found = true;
				kth_node_value = root.val;
			}
			findKthElemenet(root.right, k);
		}
	}
}
