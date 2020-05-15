package leetcode.may_challenge;
/*
 * 	Link: https://leetcode.com/problems/implement-trie-prefix-tree/
 * 	Implement a trie with insert, search, and startsWith methods.

	Example:
	Trie trie = new Trie();
	trie.insert("apple");
	trie.search("apple");   // returns true
	trie.search("app");     // returns false
	trie.startsWith("app"); // returns true
	trie.insert("app");   
	trie.search("app");     // returns true

	Note:
	You may assume that all inputs are consist of lowercase letters a-z.
	All inputs are guaranteed to be non-empty string
 */

class Trie {
	Node nodes[];

	class Node {
		boolean end;
		Trie next;

		Node() {
			end = false;
			next = null;
		}
	}

	/** Initialize your data structure here. */
	public Trie() {
		nodes = new Node[26];
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		Trie currTrie = this;
		if (currTrie.nodes[word.charAt(0) - 'a'] == null) {
			currTrie.nodes[word.charAt(0) - 'a'] = new Node();
		}
		Node prevNode = currTrie.nodes[word.charAt(0) - 'a'];
		for (int i = 1; i < word.length(); i++) {
			if (prevNode.next == null) {
				Trie trie = new Trie();
				prevNode.next = trie;
			}
			currTrie = prevNode.next;
			if (currTrie.nodes[word.charAt(i) - 'a'] == null) {
				currTrie.nodes[word.charAt(i) - 'a'] = new Node();
			}
			prevNode = currTrie.nodes[word.charAt(i) - 'a'];
		}
		prevNode.end = true;
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		Trie currTrie = this;
		int i = 0;
		boolean found = false;
		Node currNode = null;
		while (i < word.length()) {
			if (currTrie == null) {
				return false;
			}
			currNode = currTrie.nodes[word.charAt(i) - 'a'];
			if (currNode == null) {
				return false;
			}
			currTrie = currNode.next;
			i++;
		}
		return currNode.end;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given prefix.
	 */
	public boolean startsWith(String prefix) {
		Trie currTrie = this;
		int i = 0;
		boolean found = false;
		Node currNode = null;
		while (i < prefix.length()) {
			if (currTrie == null) {
				return false;
			}
			currNode = currTrie.nodes[prefix.charAt(i) - 'a'];
			if (currNode == null) {
				return false;
			}
			currTrie = currNode.next;
			i++;
		}
		return true;
	}
}

public class Day14_ImplementTrie {
	public static void main(String args[]) {
		Trie obj = new Trie();
		obj.insert("apple");
		boolean param_2 = obj.search("app");
		System.out.println(param_2);
		boolean param_3 = obj.startsWith("app");
		System.out.println(param_3);
	}
}
