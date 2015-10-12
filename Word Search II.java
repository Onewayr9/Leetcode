public class Solution {
    Set<String> result = new HashSet<String>();
    Trie trie = new Trie();
    public List<String> findWords(char[][] board, String[] words) {
        if(board.length==0||board[0].length==0){
            return new ArrayList<String>();
        }
        for(String word:words){
            trie.insert(word);
        }
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dfs(board,visited,"",i,j);
            }
        }
        return new ArrayList<String>(result);
    }
    public void dfs(char[][] board,boolean[][] visited,String temp,int i,int j){
        int m=board.length;
        int n=board[0].length;
        if(i<0 || j<0||i>=m||j>=n){
            return;
        }
        if(visited[i][j]){
            return;
        }
        temp += board[i][j];
        if(!trie.startsWith(temp)){
            return;
        }
        if(trie.search(temp)){
            result.add(temp);
        }
        visited[i][j] = true;
        dfs(board,visited,temp,i+1,j);
        dfs(board,visited,temp,i-1,j);
        dfs(board,visited,temp,i,j+1);
        dfs(board,visited,temp,i,j-1);
        visited[i][j] = false;
    }
}
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

class Trie {
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