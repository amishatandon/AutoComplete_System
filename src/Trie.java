import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Trie {
    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Insert a word into the Trie
    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            node = node.children.computeIfAbsent(ch, c -> new TrieNode());
        }
        node.isEndOfWord = true;
    }

    // Search for words with a given prefix
    public List<String> autocomplete(String prefix) {
        List<String> results = new ArrayList<>();
        TrieNode node = root;

        // Navigate to the end of the prefix
        for (char ch : prefix.toCharArray()) {
            node = node.children.get(ch);
            if (node == null) return results;
        }

        // Perform DFS to find all words with this prefix
        dfs(node, prefix, results);
        return results;
    }

    // Depth-First Search (DFS) to find all words
    private void dfs(TrieNode node, String prefix, List<String> results) {
        if (node.isEndOfWord) {
            results.add(prefix);
        }

        for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
            dfs(entry.getValue(), prefix + entry.getKey(), results);
        }
    }
}
