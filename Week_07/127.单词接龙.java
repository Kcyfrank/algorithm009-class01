import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=127 lang=java
 *
 * [127] 单词接龙
 */

// @lc code=start
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> words){
        Set<String> wordList = new HashSet<String>(words);
        if(!wordList.contains(endWord)){
            return 0;
        }
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet  = new HashSet<>();

        int len =1;
        int strlen = beginWord.length();
        HashSet<String> visited = new HashSet<>();


        beginSet.add(beginWord);
        endSet.add(endWord);

        while(!beginSet.isEmpty()&& !endSet.isEmpty()){
            if(beginSet.size()>endSet.size()){
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            Set<String> temp  = new HashSet<>();
            for(String word: beginSet){
                char[] chs = word.toCharArray();

                for (int i = 0; i < strlen; i++) {
                    char old = chs[i];
                    for (char c = 'a';c<='z';c++) {
                        chs[i] = c;
                        String target  = String.valueOf(chs);
                        if(wordList.contains(target)){
                            if(endSet.contains(target)){
                                return len+1;
                            }
                            if(!visited.contains(target) ){
                                temp.add(target);
                                visited.add(target);
                            }
                        }
                    }
                    chs[i] = old; 
                }
            }
            beginSet = temp;
            len++;
        }
        return 0;
    }
}
// @lc code=end
