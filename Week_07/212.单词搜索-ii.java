import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import sun.net.www.content.audio.basic;

/*
 * @lc app=leetcode.cn id=212 lang=java
 *
 * [212] 单词搜索 II
 * 时间 O(M(4⋅ 3^L−1))
 * 空间 On
 */

// @lc code=start
class Solution {
    
    public List<String> findWords(char[][] board, String[] words){
        WordTrie myTrie = new WordTrie();
        TrieNode root =myTrie.root;
        for(String s:words){
            myTrie.insert(s);
        }   
        
        Set<String> result = new HashSet<>();
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                find(board, visited, i,j,rows, cols, result, root);
            }
        }
        return new LinkedList<String>(result);
    }

    private void find(char[][] board, boolean[][] visited, 
        int i,int j, int rows, int cols, Set<String> result, TrieNode cur) {
        if(i<0||i>=rows||j<0||j>=cols||visited[i][j]){
            return;
        }
        cur = cur.child[board[i][j]-'a'];
        visited[i][j] = true;
        if(cur == null){
            visited[i][j] = false;
            return;
        }
        if(cur.isLeaf){
            result.add(cur.val);
        }
        find(board,visited,i+1,j,rows,cols,result,cur);
        find(board,visited,i,j+1,rows,cols,result,cur);
        find(board,visited,i,j-1,rows,cols,result,cur);
        find(board,visited,i-1,j,rows,cols,result,cur);
        visited[i][j] =false;
    }
  class WordTrie {
      public TrieNode root = new TrieNode();
      public void insert(String s){
          TrieNode cur = root;
          for (char c : s.toCharArray()) {
              if(cur.child[c-'a']== null){
                cur.child[c-'a'] = new TrieNode();
                cur = cur.child[c-'a'];
              }else{
                  cur= cur.child[c-'a'];
              }
          }
          cur.isLeaf = true;
          cur.val =s;
      }
  }
  
  class TrieNode {
      public String val;
      public TrieNode[] child;
      public boolean isLeaf;
      TrieNode() {
        child = new TrieNode[26]; 
        isLeaf= false;}
  }
    

}
// @lc code=end        