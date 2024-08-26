/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        char[] chars = new char[s.length()];
        chars = s.toCharArray();
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for (char ch : chars) {
            stack1.push(ch);
        }
        while (!stack1.isEmpty()) {
            if (stack2.isEmpty()) {
                stack2.push(stack1.pop());
            }
            if (!stack1.isEmpty()) {
                char c1 = stack1.pop();
                if (c1 == ')' || c1 == ']' || c1 == '}') {
                    stack2.push(c1);
                }
                if (c1 == '(') {
                    if (stack2.peek() == ')') {
                        stack2.pop();
                    } else {
                        stack2.push(c1);
                    }
                }
                if (c1 == '[') {
                    if (stack2.peek() == ']') {
                        stack2.pop();
                    } else {
                        stack2.push(c1);
                    }
                }
                if (c1 == '{') {
                    if (stack2.peek() == '}') {
                        stack2.pop();
                    } else {
                        stack2.push(c1);
                    }
                }
            }
        }
        return stack2.isEmpty();
    }
}
// @lc code=end
