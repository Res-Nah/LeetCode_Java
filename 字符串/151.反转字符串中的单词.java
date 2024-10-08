/*
 * @lc app=leetcode.cn id=151 lang=java
 *
 * [151] 反转字符串中的单词
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = removeSpace(s);
        reverseString(sb, 0, sb.length() - 1);
        reverseEachWord(sb);
        return sb.toString();
    }

    public StringBuilder removeSpace(String s) {
        int start = 0, end = s.length() - 1;
        while (s.charAt(start) == ' ') {
            ++start;
        }
        while (s.charAt(end) == ' ') {
            --end;
        }
        StringBuilder sb = new StringBuilder();
        while (start <= end) {
            char c = s.charAt(start);
            if (c != ' ') {
                sb.append(c);
                ++start;
            } else {
                sb.append(' ');
                while (s.charAt(start) == ' ') {
                    ++start;
                }
            }
        }
        return sb;
    }

    public void reverseString(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            ++start;
            --end;
        }
    }

    public void reverseEachWord(StringBuilder sb) {
        int start = 0, end = 0;
        while (start < sb.length()) {
            while (end < sb.length() && sb.charAt(end) != ' ') {
                ++end;
            }
            reverseString(sb, start, end - 1);
            start = end + 1;
            end = start;
        }
    }
}
// @lc code=end
