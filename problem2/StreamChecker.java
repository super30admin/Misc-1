// Time Complexity : Query -> O(q), q -> Length of query, O(m*n), m -> Number of words, n -> Average length of word
// Space Complexity : Query -> O(q), q -> Length of query, O(m*n), m -> Number of words, n -> Average length of word 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem2;

public class StreamChecker {
	TrieNode root;
	StringBuilder sb;
	int wordLen;

	public StreamChecker(String[] words) {
		root = new TrieNode();
		sb = new StringBuilder();

		for (String word : words) {
			insert(word);
			wordLen = Math.max(wordLen, word.length());
		}
	}

	public boolean query(char letter) {
		sb.append(letter);
		if (sb.length() > wordLen) {
			sb.delete(0, sb.length() - wordLen);
		}

		TrieNode curr = root;

		for (int i = sb.length() - 1; i >= 0; i--) {
			char ch = sb.charAt(i);

			if (curr.children[ch - 'a'] == null) {
				return false;
			}

			curr = curr.children[ch - 'a'];

			if (curr.isStart) {
				return true;
			}
		}
		return false;
	}

	private void insert(String word) {
		TrieNode curr = root;
		for (int i = word.length() - 1; i >= 0; i--) {
			char ch = word.charAt(i);
			if (curr.children[ch - 'a'] == null) {
				curr.children[ch - 'a'] = new TrieNode();
			}
			curr = curr.children[ch - 'a'];
		}
		curr.isStart = true;
	}

	public static void main(String[] args) {
		StreamChecker obj = new StreamChecker(new String[] { "cd", "f", "kl" });

		System.out.println(obj.query('a'));
		System.out.println(obj.query('b'));
		System.out.println(obj.query('c'));
		System.out.println(obj.query('d'));
		System.out.println(obj.query('e'));
		System.out.println(obj.query('f'));
		System.out.println(obj.query('g'));
		System.out.println(obj.query('h'));
		System.out.println(obj.query('i'));
		System.out.println(obj.query('j'));
		System.out.println(obj.query('k'));
		System.out.println(obj.query('l'));
	}

}
