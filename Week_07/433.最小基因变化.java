import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=433 lang=java
 *
 * [433] 最小基因变化
 */

// @lc code=start
class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> banks = new HashSet<>(Arrays.asList( bank));
        if(!banks.contains(end)){
            return -1;
        }
        int len = 1;
        char[] eles  = new char[]{'A','C','G','T'};

        Set<String> visited = new HashSet<>();
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();

        beginSet.add(start);
        endSet.add(end);

        while(!beginSet.isEmpty()&&!endSet.isEmpty()){
            if(beginSet.size()>endSet.size()){
                Set<String> temp = beginSet;
                beginSet=endSet;
                endSet = temp;
            }
            Set<String> temp = new HashSet<>();
            //8字节 4字符
            for(String word : beginSet){
                char[] chs = word.toCharArray();
                for(int i =0;i<8;i++){
                    char old = chs[i];

                    for(int j = 0;j<4;j++){
                        chs[i] = eles[j];
                        String target = String.valueOf(chs);
                        if(banks.contains(target)){
                            if(endSet.contains(target)){
                                return len;
                            }
                            if(!visited.contains(target)){
                                visited.add(target);
                                temp.add(target);
                            }
                        }

                    }
                    chs[i] = old;
                }
            }
            beginSet = temp;
            len++;

        }

        return -1;
    }
}
// @lc code=end

