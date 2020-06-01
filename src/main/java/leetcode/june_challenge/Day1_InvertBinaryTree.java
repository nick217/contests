package leetcode.june_challenge;

/*
 * 	Link: https://leetcode.com/problems/invert-binary-tree/
 * 	Invert a binary tree.
	Example:

	Input:

     4
   /   \
  2     7
 / \   / \
1   3 6   9

	Output:

     4
   /   \
  7     2
 / \   / \
9   6 3   1

	Trivia:
	This problem was inspired by this original tweet by Max Howell:
	Google: 90% of our engineers use the software you wrote (Homebrew), 
	but you can’t invert a binary tree on a whiteboard so f*** off.
 */
public class Day1_InvertBinaryTree {
	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return root;
		}
		invertTree(root.left);
		invertTree(root.right);

		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		return root;
	}
}
