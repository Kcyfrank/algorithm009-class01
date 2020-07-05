/*
 * @lc app=leetcode.cn id=208 lang=java
 *
 * [208] 实现 Trie (前缀树)
 * 时间 On
 * 空间 On
 */
// @lc code=start
class TrieNode {
    boolean is_word_end;
    Map<Character, TrieNode> children;
    public TrieNode(){
        is_word_end = false;
        children = new HashMap<>(26);
    }
}
class Trie {
    TrieNode node;

    /** Initialize your data structure here. */
    public Trie() {
        node = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] words = word.toCharArray();
        TrieNode curNode = node;        
        for(char c:words){
            if(!curNode.children.containsKey(c)){
                curNode.children.put(c, new TrieNode());
            }
            curNode = curNode.children.get(c);
        }
        curNode.is_word_end = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] words = word.toCharArray();
        TrieNode curNode = node;
        for(char c:words){
            if(!curNode.children.containsKey(c)){
                return false;
            }
            curNode = curNode.children.get(c);
        }
        return curNode.is_word_end; 
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] words = prefix.toCharArray();
        TrieNode curNode = node;
        for(char c:words){
            if(!curNode.children.containsKey(c)){
                return false;
            }
            curNode = curNode.children.get(c);
        }
        return true;
    }
}
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end

