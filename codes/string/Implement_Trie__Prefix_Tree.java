class Trie {

    static class TrieNode{
        TrieNode[] children;
        boolean isEndOfWord;
        
        TrieNode(){
            children = new TrieNode[26];
            isEndOfWord = false;
        }
    }

    private TrieNode root ;

    public Trie() {
        root = new TrieNode();
    }

    private TrieNode getNode(){
        return new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode temp = root;

        for(int i=0;i<word.length();i++){

            int index = word.charAt(i) -'a';

            if(temp.children[index] == null){
                temp.children[index] = getNode();
            }
            temp =  temp.children[index];
        }
        temp.isEndOfWord = true;

    }
    public boolean search(String word) {
        TrieNode temp = root;

        for(char ch : word.toCharArray()){
            int index = ch -'a';

            if(temp.children[index] == null){
                return false;
            }
            temp = temp.children[index];
        }

        return temp != null && temp.isEndOfWord;
    }
    
    public boolean startsWith(String prefix) {
        
        TrieNode temp = root;

        int i=0;
        
        for(;i<prefix.length();i++){
            int index = prefix.charAt(i) - 'a';
            if(temp.children[index] == null){
                return false;
            }
            temp = temp.children[index];
        }
        if(i == prefix.length()){
            return true;
        }
        return false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */



public class Implement_Trie__Prefix_Tree{
    public static void main(String[] args) {
        
    }
}

