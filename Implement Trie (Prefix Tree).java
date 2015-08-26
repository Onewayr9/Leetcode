import java.util.HashMap;
class TrieNode {
    // Initialize your data structure here.
    boolean isWord = false;
    String val;
    HashMap<Character,TrieNode> children = new HashMap<Character,TrieNode>();
    public TrieNode(String val) {
        this.val = val;
    }
    public TrieNode(){
        this.val = "";
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode use = root;
        for(int i=0;i<word.length();i++){
            if(!use.children.containsKey(word.charAt(i))) use.children.put(word.charAt(i),new TrieNode(use.val+word.charAt(i)));
            use = use.children.get(word.charAt(i));
        }
        use.isWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode use = root;
        for(int i=0;i<word.length();i++){
            if(!use.children.containsKey(word.charAt(i))) return false;
            else use = use.children.get(word.charAt(i));
        }
        return use.isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode use = root;
        for(int i=0;i<prefix.length();i++){
            if(!use.children.containsKey(prefix.charAt(i))) return false;
            else use = use.children.get(prefix.charAt(i));
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");