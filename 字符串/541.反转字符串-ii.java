/*
 * @lc app=leetcode.cn id=541 lang=java
 *
 * [541] 反转字符串 II
 */

// @lc code=start
class Solution {
    public String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();
        for(int i = 0; i < ch.length; i += 2 * k) {
            if(i + k <= ch.length) {
                reverse(ch, i, i + k - 1);
                continue;
            }
            reverse(ch, i, ch.length - 1);
        }
        return new String(ch);
    }

    public void reverse(char[] ch, int left, int right) {
        while(left < right) {
            char temp = ch[left];
            ch[left] = ch[right];
            ch[right] = temp;
            right--;
            left++;
        }
    }
}
// @lc code=end

