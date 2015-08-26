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
public class WordDictionary {
    private TrieNode root;
    public WordDictionary(){
        root = new TrieNode();
    }
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode use = root;
        for(int i=0;i<word.length();i++){
            if(!use.children.containsKey(word.charAt(i))) use.children.put(word.charAt(i),new TrieNode(use.val+word.charAt(i)));
            use = use.children.get(word.charAt(i));
        }
        use.isWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return search(root,word);
    }
    public boolean search(TrieNode root, String word){
        TrieNode use = root;
        boolean ans = false;
        for(int i=0;i<word.length();i++){
            if(word.charAt(i)=='.'){
                if(word.length()==1||i==word.length()-1){
                    for(Map.Entry<Character,TrieNode> entry: use.children.entrySet()){
                        if(entry.getValue().isWord) return true;
                    }
                    return false;
                }
                for(Map.Entry<Character,TrieNode> entry: use.children.entrySet()){
                    ans = ans||search(entry.getValue(),word.substring(i+1));
                }
                if(ans==false) return false;
                else return true;
            }
            else if(!use.children.containsKey(word.charAt(i))) return false;
            else use = use.children.get(word.charAt(i));
        }
        return use.isWord;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");