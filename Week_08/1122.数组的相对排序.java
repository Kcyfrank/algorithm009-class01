/*
 * @lc app=leetcode.cn id=1122 lang=java
 *
 * [1122] 数组的相对排序
 */

// @lc code=start
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[1001];
        for (int i : arr1) {
            count[i]++;
        }
        int[] result = new int[arr1.length];
        int index=0;
        for(int i:arr2){
            while(count[i]>0){
                arr1[index++]= i;
                count[i]--;
            }
        }
         for (int num1 = 0; num1 < count.length; num1++) {
            while (count[num1] > 0) {
                arr1[index++] = num1;
                count[num1]--;
            }
        }
        return arr1;
    }
}
// @lc code=end

