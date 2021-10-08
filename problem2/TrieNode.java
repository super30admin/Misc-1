package problem2;

public class TrieNode {
	TrieNode[] children;
	boolean isStart;

	public TrieNode() {
		this.children = new TrieNode[26];
	}
}
