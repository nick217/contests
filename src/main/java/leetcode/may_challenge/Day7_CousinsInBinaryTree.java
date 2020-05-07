package leetcode.may_challenge;
/*
  	Link: 
  	In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
  	Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
  	We are given the root of a binary tree with unique values, and the values x and y of two 
  	different nodes in the tree.
  	Return true if and only if the nodes corresponding to the values x and y are cousins.
 */

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class Day7_CousinsInBinaryTree {
	int xHt = -1;
	int yHt = -1;

	public boolean isCousins(TreeNode root, int x, int y) {
		if (root.val == x || root.val == y) {
			return false;
		}
		boolean parentsAreSame = sameParents(root, x, y, 0);
		if (parentsAreSame) {
			return false;
		}
		if (yHt == -1) {
			findY(root, y, 0);
		}
		return xHt == yHt;

	}

	public void findY(TreeNode node, int y, int ht) {
		if (node != null && yHt == -1) {
			if (node.val == y) {
				yHt = ht;
			} else {
				findY(node.left, y, ht + 1);
				findY(node.right, y, ht + 1);
			}
		}
	}

	public boolean sameParents(TreeNode node, int x, int y, int ht) {
		boolean leftResult = false;
		boolean rightResult = false;
		if (node.left != null) {
			if (node.left.val == x) {
				xHt = ht + 1;
				if (node.right != null && node.right.val == y) {
					return true;
				} else {
					return false;
				}
			} else {
				leftResult = sameParents(node.left, x, y, ht + 1);
			}
		}
		if (node.right != null && xHt == -1) {
			if (node.right.val == x) {
				xHt = ht + 1;
				if (node.left != null && node.left.val == y) {
					return true;
				} else {
					return false;
				}
			} else {
				rightResult = sameParents(node.right, x, y, ht + 1);
			}
		}
		if (node.val == y) {
			yHt = ht;
		}
		return leftResult || rightResult;
	}
}
